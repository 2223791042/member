package guet.ty.member.controller;

import guet.ty.member.VO.ResultVO;
import guet.ty.member.entity.Manager;
import guet.ty.member.service.ManagerService;
import guet.ty.member.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @PostMapping("/login")
    public ResultVO login(String username, String password, String verifyCode, HttpSession httpSession){
        //获取保存验证码
        String saveVerifyCode = (String) httpSession.getAttribute("verifyCode");
        //校验验证码
        if (!verifyCode.toUpperCase().equals(saveVerifyCode.toUpperCase())){
            return ResultVOUtil.fail("验证码错误");
        }
        //获取保存管理员信息
        Manager saveManager = managerService.getManager(username);
        //校验用户信息
        if (saveManager == null){
            return ResultVOUtil.fail("该用户不存在");
        }
        if (!saveManager.getManagerPassword().equals(password)){
            return ResultVOUtil.fail("密码错误");
        }
        //保存登录时间
        httpSession.setAttribute("loginTime", new Date());
        //保存管理员信息
        httpSession.setAttribute("manager", saveManager);
        return ResultVOUtil.success();
    }

    @GetMapping("/logout")
    public ResultVO logout(HttpSession httpSession){
        //获取管理员登录信息
        Manager manager = (Manager) httpSession.getAttribute("manager");
        //获取管理员登录时间
        Date loginTime = (Date) httpSession.getAttribute("loginTime");
        //修改上次登录时间
        manager.setManagerLastTime(loginTime);
        //修改用户信息
        try{
            managerService.editManager(manager);
            //session 销毁
            httpSession.invalidate();
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail();
        }
    }

    @GetMapping("/info")
    public ResultVO info(HttpSession httpSession){
        //获取管理员登录信息
        Manager manager = (Manager) httpSession.getAttribute("manager");
        return ResultVOUtil.success("管理员信息", manager);
    }
}
