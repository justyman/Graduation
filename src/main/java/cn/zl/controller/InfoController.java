package cn.zl.controller;

import cn.zl.pojo.Info;
import cn.zl.pojo.ResultBean;
import cn.zl.service.StaffService;
import cn.zl.utils.Constants;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author ZL.
 * @project Graduation
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/3/26 9:54
 * @des 个人中心模块——个人信息
 */
@Controller
public class InfoController {
    @Resource
    private StaffService staffService;

    /**
     * 跳转至个人信息页面
     */
    @RequestMapping("/info")
    public ModelAndView info(){
        return new ModelAndView("info");
    }

    /**
     * 取得个人信息返回至前端
     */
    @RequestMapping("/staffInfo")
    @ResponseBody
    public ResultBean staffInfo(){
        // 得到用户信息
        Info info = new Info();
        ResultBean resultBean = staffService.getInfo(info);
        if(Constants.RESULT_FAILURE.equals(resultBean.getResult())){
            return resultBean;
        }
        resultBean.setResult(Constants.RESULT_SUCCESS);
        resultBean.setMessage(JSON.toJSONString(info));
        return resultBean;
    }
}
