package guet.ty.member.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import guet.ty.member.VO.CardListVO;
import guet.ty.member.VO.ResultVO;
import guet.ty.member.VO.TableVO;
import guet.ty.member.entity.Card;
import guet.ty.member.entity.Chargeinfo;
import guet.ty.member.entity.Manager;
import guet.ty.member.entity.Member;
import guet.ty.member.service.CardService;
import guet.ty.member.service.MemberService;
import guet.ty.member.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 罗惠铎 on 2019/5/6.
 */
@RestController
public class CardController {
    @Autowired
    private CardService cardService;
    @Autowired
    private MemberService memberService;
    //根据手机号查询
    @GetMapping("/getCard")
    public CardListVO getCardByPhone(HttpServletRequest request){
        String phone=request.getParameter("memberPhone");
        Card card=cardService.getCard(phone);
        Member member=memberService.getMember(phone);
        CardListVO cardListVO=new CardListVO();

        BeanUtils.copyProperties(card, cardListVO);
        BeanUtils.copyProperties(member,cardListVO);

        return cardListVO;
    }
    //会员卡充值
    @PostMapping("/charge")
    public ResultVO cardCharge(HttpServletRequest request, HttpSession httpSession){
        //获取当前管理员信息
        Manager manager = (Manager) httpSession.getAttribute("manager");
        Long chargeCardId=Long.parseLong(request.getParameter("chargeCardId"));
        BigDecimal chargeMoney=new BigDecimal(request.getParameter("cardChargeMoney"));
        Chargeinfo chargeinfo=new Chargeinfo();
        chargeinfo.setChargeCardId(chargeCardId);
        chargeinfo.setChargeHandler(manager.getManagerName());
        chargeinfo.setChargeMoney(chargeMoney);
        chargeinfo.setChargeTime(new Date());
        Card card=cardService.getCard(request.getParameter("chargeCardId"));
        BigDecimal bigDecimal1=new BigDecimal(0.03);
        BigDecimal bigDecimal2=new BigDecimal(0.08);
        BigDecimal bigDecimal3=new BigDecimal(0.1);
        if(card.getCardGrade()==0) {
            chargeMoney=chargeMoney.add(chargeMoney.multiply(bigDecimal1));
        }else if(card.getCardGrade()==1){
            chargeMoney=chargeMoney.add(chargeMoney.multiply(bigDecimal2));
        }else{
            chargeMoney=chargeMoney.add(chargeMoney.multiply(bigDecimal3));
        }

        BigDecimal total=chargeMoney.add(card.getCardChargeMomey());
        BigDecimal balanceMoney=chargeMoney.add(card.getCardBalance());
        card.setCardBalance(balanceMoney);
        card.setCardChargeMomey(total);
        card.setCardChargeTimes(card.getCardChargeTimes()+1);

        try{
            cardService.saveCharge(chargeinfo);
            cardService.editCard(card);
            return ResultVOUtil.success();
        }catch(Exception e){
            return ResultVOUtil.fail();
        }
    }

    //会员id(精确) 会员姓名(模糊) 开卡时间(xxx-xxx) 查询

    @GetMapping("/cardList")
    public TableVO<CardListVO> cardList(Integer cardGrade, int page, int limit, HttpServletRequest request){
        List<CardListVO> ordinaryList=new ArrayList<>();
        //开启分页查询
        PageHelper.startPage(page, limit);
        //用户名
        String memberName = request.getParameter("memberName");
        //手机号
        String memberPhone = request.getParameter("id");
        //加入时间（开始-结束）
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime = null;
        Date endTime = null;
        try{
            if (request.getParameter("startTime") != null && !request.getParameter("startTime").equals("")){
                startTime = simpleDateFormat.parse(request.getParameter("startTime"));
            }
            if (request.getParameter("endTime") != null && !request.getParameter("endTime").equals("")){
                endTime = simpleDateFormat.parse(request.getParameter("endTime"));
                endTime = new Date(endTime.getTime()+86400000-1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //处理者
        String memberHandler = request.getParameter("memberHandler");
        List<Member> memberList = memberService.getMemberList(cardGrade, memberName, memberPhone, startTime, endTime, memberHandler);
        for(Member member:memberList){
            Card card = cardService.getCard(member.getMemberPhone());
            CardListVO cardListVO=new CardListVO();
            BeanUtils.copyProperties(card, cardListVO);
            BeanUtils.copyProperties(member,cardListVO);
            ordinaryList.add(cardListVO);
        }
        PageInfo<Member> pageInfo = new PageInfo<>(memberList);
        return new TableVO<>(pageInfo, ordinaryList);
    }
}
