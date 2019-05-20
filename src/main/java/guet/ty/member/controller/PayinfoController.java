package guet.ty.member.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import guet.ty.member.VO.ResultVO;
import guet.ty.member.VO.TableVO;
import guet.ty.member.dto.PayinfoDTO;
import guet.ty.member.entity.Manager;
import guet.ty.member.entity.Member;
import guet.ty.member.entity.Payinfo;
import guet.ty.member.service.PayinfoService;
import guet.ty.member.utils.DateUtil;
import guet.ty.member.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class PayinfoController {
    @Autowired
    private PayinfoService payinfoService;

    @PostMapping("/payinfo")
    public ResultVO payinfoAdd(HttpSession httpSession, HttpServletRequest request) {
        //获取手机号查询
        String memberPhone= request.getParameter("memberPhone");
        //获取当前管理员信息
        Manager manager = (Manager) httpSession.getAttribute("manager");
        //获取消费信息
        Integer payKind= Integer.parseInt(request.getParameter("payKind"));
        String payDesc= request.getParameter("payDesc");
        BigDecimal payMoney=BigDecimal.valueOf(Long.parseLong(request.getParameter("payMoney")));
        Integer payMethod=Integer.parseInt(request.getParameter("payMethod"));
        long phone=Long.parseLong(request.getParameter("memberPhone"));

        //生成消费信息
        Payinfo payinfo = new Payinfo();
        payinfo.setPayCardId(phone);
        payinfo.setPayKind(payKind);
        payinfo.setPayDesc(payDesc);
        payinfo.setPayMoney(payMoney);
        payinfo.setPayMethod(payMethod);
        payinfo.setPayTime(new Date());
        payinfo.setPayHandler(manager.getManagerName());

        payinfoService.payinfoSearchByPhone(memberPhone);
        try {
            payinfoService.addPayinfo(payinfo);
            return ResultVOUtil.success();
        } catch (Exception e) {
            return ResultVOUtil.fail();
        }

    }

    @GetMapping("/payinfoSearch")
    public TableVO<Member> memberSearch( HttpSession httpSession, HttpServletRequest request) {
        //获取当前管理员信息
        String memberPhone=request.getParameter("memberPhone");
        List<Member> payinfoDTOList=payinfoService.payinfoSearchByPhone(memberPhone);
        PageInfo<Member> pageInfo = new PageInfo<>(payinfoDTOList);
        return new TableVO<>(pageInfo, payinfoDTOList);
    }

    @GetMapping("/payinfoList")
    public TableVO<PayinfoDTO> payinfoList(int page, int limit,int payKind, HttpServletRequest request, HttpSession httpSession){
        //开启分页查询
        PageHelper.startPage(page, limit);

        //用户名
        String memberName = request.getParameter("memberName");
        //用户id
        String memberPhone = request.getParameter("memberId");
        //消费时间
        Date startTime = DateUtil.getStart(request);
        Date endTime = DateUtil.getEnd(request);
        //处理者
        String memberHandler = request.getParameter("memberHandler");
        Map<String,Object> map= payinfoService.getPayinfoList(payKind, memberPhone, memberName, startTime, endTime, memberHandler);
        List<PayinfoDTO> payinfoDTOList=(List<PayinfoDTO>)map.get("PayinfoList");
        PageInfo pageInfo=(PageInfo)map.get("pageInfo") ;
        return new TableVO<>(pageInfo,payinfoDTOList);
    }

    @GetMapping("/payinfo/{memberPhone}")
    public ResultVO memberExist(@PathVariable("memberPhone")String memberPhone){
        //查询是否存在
        List<Payinfo> saveMember = payinfoService.getMember(memberPhone);
        if (saveMember != null){
            return ResultVOUtil.found();
        }
        return ResultVOUtil.notFound();
    }
}
