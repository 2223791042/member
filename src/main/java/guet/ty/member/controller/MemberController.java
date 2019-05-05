package guet.ty.member.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import guet.ty.member.VO.ResultVO;
import guet.ty.member.VO.TableVO;
import guet.ty.member.entity.Card;
import guet.ty.member.entity.Manager;
import guet.ty.member.entity.Member;
import guet.ty.member.service.CardService;
import guet.ty.member.service.MemberService;
import guet.ty.member.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private CardService cardService;

    @PostMapping("/member")
    public ResultVO memberAdd(Member member, HttpSession httpSession){
        //获取当前管理员信息
        Manager manager = (Manager) httpSession.getAttribute("manager");
        member.setMemberJoinTime(new Date());//设置会员加入日期
        member.setMemberHandler(manager.getManagerName());//设置会员处理者
        //生成会员的同时，生成一张会员卡
        Card card = new Card();
        card.setCardId(member.getMemberPhone());//设置卡的Id
        card.setCardGrade(member.getMemberGrade());//设置卡的等级
        card.setCardBalance(0f);//设置卡的余额
        card.setCardPoints(0);//设置卡的积分
        card.setCardCreateTime(new Date());//设置开卡时间
        card.setCardPayTimes(0);//设置总消费次数
        card.setCardPayMoney(0f);//设置总消费金额
        card.setCardChargeTimes(0);//设置总充值次数
        card.setCardChargeMomey(0f);//设置总充值金额
        //保存
        try {
            memberService.saveMember(member);
            cardService.saveCard(card);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail();
        }
    }

    @GetMapping("/memberList")
    public TableVO<Member> memberList(Integer memberGrade, int page, int limit, HttpServletRequest request){
        //开启分页查询
        PageHelper.startPage(page, limit);
        //用户名
        String memberName = request.getParameter("memberName");
        //手机号
        String memberPhone = request.getParameter("memberPhone");
        //加入时间（开始-结束）
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime = null;
        Date endTime = null;
        try{
            if (request.getParameter("startTime") != null){
                startTime = simpleDateFormat.parse(request.getParameter("startTime"));
            }
            if (request.getParameter("endTime") != null){
                endTime = simpleDateFormat.parse(request.getParameter("endTime"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //处理者
        String memberHandler = request.getParameter("memberHandler");
        List<Member> memberList = memberService.getMemberList(memberGrade, memberName, memberPhone, startTime, endTime, memberHandler);
        PageInfo<Member> pageInfo = new PageInfo<>(memberList);
        return new TableVO<>(pageInfo, memberList);
    }

    @PutMapping("/member/{memberId}")
    public ResultVO memberEdit(@PathVariable("memberId")Long memberId, Member member, HttpSession httpSession){
        //获取当前管理员信息
        Manager manager = (Manager) httpSession.getAttribute("manager");
        member.setMemberHandler(manager.getManagerName());//设置会员处理者
        //设置要修改的Id
        member.setMemberId(memberId);
        try{
            //准备修改会员等级
            if (member.getMemberGrade() != null){
                //获取会员信息
                Member saveMember = memberService.getMember(memberId);
                //获取会员卡
                Card saveCard = cardService.getCard(saveMember.getMemberPhone());
                //修改会员卡等级
                saveCard.setCardGrade(member.getMemberGrade());
                //修改保存
                cardService.editCard(saveCard);
            }
            //修改保存
            memberService.editMemeber(member);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail();
        }
    }
}
