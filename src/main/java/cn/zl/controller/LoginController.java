package cn.zl.controller;

import cn.zl.domain.Staff;
import cn.zl.pojo.ResultBean;
import cn.zl.utils.Constants;
import cn.zl.utils.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
     * 登陆成功跳转至用户页面
     */
    @RequestMapping("/user")
    public ModelAndView user(){
        return new ModelAndView("user");
    }

    /**
     * 用户登陆
     */
    @RequestMapping("/login")
    @ResponseBody
    public ResultBean login(@RequestBody Staff staff){
        ResultBean resultBean = new ResultBean();
        // 字段校验
        if(StringUtil.isEmpty(staff.getUsername()) || StringUtil.isEmpty(staff.getPassword())){
            resultBean.setResult(Constants.RESULT_FAILURE);
            resultBean.setMessage("账号或者密码不能为空！");
            return resultBean;
        }
        // 用户登陆
        UsernamePasswordToken token = new UsernamePasswordToken(staff.getUsername(), staff.getPassword());
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        resultBean.setResult(Constants.RESULT_SUCCESS);
        return resultBean;
    }
}
