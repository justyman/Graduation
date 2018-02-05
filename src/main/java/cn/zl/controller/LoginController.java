package cn.zl.controller;

import cn.zl.po.Staff;
import cn.zl.service.User;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private User user;

    @RequestMapping("/login")
    public ModelAndView login(String username, String password){
        Staff staff = user.getUser(username);
        if(staff.getPassword().equals(password)){
            return new ModelAndView("user");
        }
        return null;
    }
}
