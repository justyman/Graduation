package cn.zl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ZL.
 * @project Graduation
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/4/4 16:06
 * @des 管理员模块
 */
@Controller
public class ManageController {
    /**
     * 跳转至用户管理页面
     */
    @RequestMapping("staffManage")
    public ModelAndView staffManage(){
        return new ModelAndView("manage/staffs");
    }

    /**
     * 跳转至角色管理页面
     */
    @RequestMapping("positionManage")
    public ModelAndView positionManage(){
        return new ModelAndView("manage/positions");
    }

    /**
     * 跳转至日志管理页面
     */
    @RequestMapping("logManage")
    public ModelAndView logManage(){
        return new ModelAndView("manage/logs");
    }
}
