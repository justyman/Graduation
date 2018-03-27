package cn.zl.controller;

import cn.zl.domain.Reset;
import cn.zl.domain.Staff;
import cn.zl.pojo.Info;
import cn.zl.pojo.ResultBean;
import cn.zl.service.StaffService;
import cn.zl.utils.Constants;
import cn.zl.utils.StringUtil;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * @author ZL.
 * @project CreditCard
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/1/23 15:19
 * @des 登陆模块、修改密码模块
 */

@Controller
public class LoginController {
    private static final Logger log = Logger.getLogger("OPERATION");

    @Autowired
    private StaffService staffService;

    /**
     * 登陆成功跳转至用户页面
     */
    @RequestMapping("/user")
    public ModelAndView user() {
        return new ModelAndView("user");
    }

    /**
     * 用户登陆
     */
    @RequestMapping("/login")
    @ResponseBody
    public ResultBean login(@RequestBody Staff staff) {
        ResultBean resultBean = new ResultBean();
        MDC.put("username", staff.getUsername());
        // 字段校验
        if (StringUtil.isEmpty(staff.getUsername()) || StringUtil.isEmpty(staff.getPassword())) {
            resultBean.setResult(Constants.RESULT_FAILURE);
            resultBean.setMessage("账号或者密码不能为空！");
            return resultBean;
        }
        // 用户登陆
        UsernamePasswordToken token = new UsernamePasswordToken(staff.getUsername(), staff.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            resultBean.setResult(Constants.RESULT_FAILURE);
            log.info("shiro异常：" + e.getMessage().substring(0, 200));
            return resultBean;
        }
        // 得到用户信息
        Info info = new Info();
        resultBean = staffService.getInfo(info);
        if(Constants.RESULT_FAILURE.equals(resultBean.getResult())){
            return resultBean;
        }
        // 返回json
        String json = JSON.toJSONString(info);
        resultBean.setResult(Constants.RESULT_SUCCESS);
        resultBean.setMessage(json);
        log.info("登陆成功");
        return resultBean;
    }

    /**
     * 修改用户密码
     */
    @RequestMapping("/reset")
    @ResponseBody
    public ResultBean reset(@RequestBody Reset reset) {
        ResultBean resultBean = new ResultBean();
        // 字段校验
        if (StringUtil.isEmpty(reset.getUsername()) || StringUtil.isEmpty(reset.getResetword())) {
            resultBean.setResult(Constants.RESULT_FAILURE);
            resultBean.setMessage("账号或者密码不能为空！");
            return resultBean;
        } else if (StringUtil.isEmpty(reset.getResetword()) || StringUtil.isEmpty(reset.getReason())) {
            resultBean.setResult(Constants.RESULT_FAILURE);
            resultBean.setMessage("重置密码或理由不能空！");
            return resultBean;
        }
        // 获取申请时间
        reset.setTime(new Date());

        return staffService.reset(reset);
    }
}
