package cn.zl.controller;

import cn.zl.domain.extend.CaseExtend;
import cn.zl.pojo.QueryCaseBean;
import cn.zl.pojo.ResultBean;
import cn.zl.service.CommonService;
import cn.zl.utils.Constants;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZL.
 * @project Graduation
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/4/9 16:33
 * @des 公用方法控制层
 */
@Controller
public class CommonController {
    @Resource
    private CommonService commonService;

    /**
     * 按条件分页查询信用卡工单结果
     * 每次查询默认分页：每页记录数10，显示第一页数据
     */
    @RequestMapping("/queryCase")
    @ResponseBody
    public ResultBean queryCase(@RequestBody QueryCaseBean caseBean){
        ResultBean resultBean = new ResultBean();
        CaseExtend caseExtend = new CaseExtend();
        PageInfo pageInfo = new PageInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        Page page;
        List queryList;
        try {
            BeanUtils.copyProperties(caseExtend, caseBean);
            BeanUtils.copyProperties(pageInfo, caseBean);
            queryList = commonService.getCase(caseExtend, pageInfo);
            page = (Page)queryList;
        } catch (Exception e) {
            resultBean.setResult(Constants.RESULT_FAILURE);
            e.getStackTrace();
            return resultBean;
        }
        map.put("list", queryList);
        map.put("pageNum", page.getPageNum());
        map.put("total", page.getTotal());
        resultBean.setMessage(JSON.toJSONString(map));
        resultBean.setResult(Constants.RESULT_SUCCESS);
        return resultBean;
    }
}
