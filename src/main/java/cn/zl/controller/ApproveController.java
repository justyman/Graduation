package cn.zl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ZL.
 * @project Graduation
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/4/4 16:01
 * @des 审批模块
 */
@Controller
public class ApproveController {
    /**
     * 跳转至查询客户信息页面
     */
    @RequestMapping("approveQuery")
    public ModelAndView info(){
        return new ModelAndView("approve/queryCase");
    }

    /**
     * 跳转至工单查询的详细信息页面
     */
    @RequestMapping("approveQueryDetail")
    public ModelAndView detail(){
        return new ModelAndView("approve/detail");
    }

    /**
     * 跳转至审批信息页面
     */
    @RequestMapping("approveCard")
    public ModelAndView card(){
        return new ModelAndView("approve/approveCase");
    }

    /**
     * 跳转至异常信息页面
     */
    @RequestMapping("approveException")
    public ModelAndView exception(){
        return new ModelAndView("approve/exceptionCase");
    }

    /**
     * 跳转至信用评估页面
     */
    @RequestMapping("approveCustomer")
    public ModelAndView credit(){
        return new ModelAndView("approve/approveCredit");
    }
}
