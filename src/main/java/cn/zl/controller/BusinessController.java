package cn.zl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ZL.
 * @project Graduation
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/4/4 16:05
 * @des 业务模块
 */
@Controller
public class BusinessController {
    /**
     * 跳转至查询客户信息页面
     */
    @RequestMapping("businessQuery")
    public ModelAndView info(){
        return new ModelAndView("business/queryCase");
    }

    /**
     * 跳转至工单查询的详细信息页面
     */
    @RequestMapping("businessQueryDetail")
    public ModelAndView detail(){
        return new ModelAndView("business/detail");
    }

    /**
     * 跳转至异常信息页面
     */
    @RequestMapping("businessException")
    public ModelAndView exception(){
        return new ModelAndView("business/exceptionCase");
    }
}
