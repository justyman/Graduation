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
    @RequestMapping("/approveQuery")
    public ModelAndView info(){
        return new ModelAndView("approve/customer");
    }
}
