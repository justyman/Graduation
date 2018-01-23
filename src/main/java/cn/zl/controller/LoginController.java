package cn.zl.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ZL.
 * @project CreditCard
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/1/23 15:19
 * @des 登陆模块
 */

@Controller
public class LoginController {
    @RequestMapping("/login")
    public ModelAndView login(String username, String password){
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();

        return new ModelAndView("user");
    }
}
