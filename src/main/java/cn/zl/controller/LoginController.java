package cn.zl.controller;

import cn.zl.utils.StringUtil;
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

    /**
     * 用户登陆
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(String username, String password){
        ModelAndView mav = new ModelAndView();
        // 字段校验
        if(StringUtil.isEmpty(username) || StringUtil.isEmpty(password)){
            mav.addObject("message", "用户名或密码不能为空！");
            return mav;
        }
        // 用户登陆
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        mav.setViewName("user");
        return mav;
    }
}
