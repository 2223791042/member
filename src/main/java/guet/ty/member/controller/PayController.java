package guet.ty.member.controller;

import guet.ty.member.VO.ResultVO;
import guet.ty.member.entity.Payinfo;
import guet.ty.member.service.PayinfoService;
import guet.ty.member.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by 罗惠铎 on 2019/5/19.
 */
@RestController
public class PayController {
    @Autowired
    private PayinfoService payInfoService;

    @PostMapping("/recordPay")
    //消费记录
    public ResultVO recordPay(Payinfo payInfo, HttpSession httpSession){
        //会员卡id  消费金额 支付方式 消费描述 备注信息 消费时间 处理者
        //Manager manager = (Manager) httpSession.getAttribute("manager");
        //payInfo.setPayHandler(manager.getManagerName());
        try {
            payInfoService.savePayInfo(payInfo);
            return ResultVOUtil.success();
        }catch(Exception e){
            return ResultVOUtil.fail();
        }
    }
}
