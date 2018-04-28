package cn.zl.controller;

import cn.zl.domain.Customer;
import cn.zl.domain.Staff;
import cn.zl.domain.extend.CaseExtend;
import cn.zl.pojo.Detail;
import cn.zl.pojo.QueryCaseBean;
import cn.zl.pojo.QueryCusBean;
import cn.zl.pojo.ResultBean;
import cn.zl.service.CommonService;
import cn.zl.utils.Constants;
import cn.zl.utils.SessionUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
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
    private static final Logger log = Logger.getLogger("OPERATION");

    @Resource
    private CommonService commonService;

    /**
     * 按条件分页查询信用卡工单结果
     * 每次查询默认分页：每页记录数10，显示第一页数据
     */
    @RequestMapping("queryCase")
    @ResponseBody
    public ResultBean queryCase(@RequestBody QueryCaseBean caseBean){
        MDC.put("username", ((Staff)SessionUtil.getStaffSession()).getUsername());
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
            log.info("查询工单异常：" + (e.getMessage().length() > 200 ? e.getMessage().substring(0, 200) : e.getMessage()));
            return resultBean;
        }
        map.put("list", queryList);
        map.put("pageNum", page.getPageNum());
        map.put("total", page.getTotal());
        map.put("pages", page.getPages());
        resultBean.setMessage(JSON.toJSONString(map));
        resultBean.setResult(Constants.RESULT_SUCCESS);
        return resultBean;
    }

    /**
     * 查询工单详细信息
     */
    @RequestMapping("queryDetail")
    @ResponseBody
    public ResultBean detail(String card){
        MDC.put("username", ((Staff)SessionUtil.getStaffSession()).getUsername());
        ResultBean resultBean = new ResultBean();
        Detail detail;
        try {
            detail = commonService.getDetail(card);
        } catch (Exception e) {
            resultBean.setResult(Constants.RESULT_FAILURE);
            log.info("查询卡号{" + card + "}异常：" + (e.getMessage().length() > 200 ? e.getMessage().substring(0, 200) : e.getMessage()));
            return resultBean;
        }
        if(detail == null){
            resultBean.setResult(Constants.RESULT_FAILURE);
            log.info("查询卡号{" + card + "}无数据");
            return resultBean;
        }
        resultBean.setMessage(JSON.toJSONString(detail));
        resultBean.setResult(Constants.RESULT_SUCCESS);
        return resultBean;
    }

    /**
     * 查询客户信息
     */
    @RequestMapping("queryCustomer")
    @ResponseBody
    public ResultBean queryCustomer(@RequestBody QueryCusBean queryCusBean){
        MDC.put("username", ((Staff)SessionUtil.getStaffSession()).getUsername());
        ResultBean resultBean = new ResultBean();
        Customer customer = new Customer();
        PageInfo pageInfo = new PageInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        Page page;
        List queryList;
        try {
            BeanUtils.copyProperties(customer, queryCusBean);
            BeanUtils.copyProperties(pageInfo, queryCusBean);
            queryList = commonService.getCustomer(customer, pageInfo);
            page = (Page)queryList;
        } catch (Exception e) {
            resultBean.setResult(Constants.RESULT_FAILURE);
            log.info("查询客户信息异常：" + (e.getMessage().length() > 200 ? e.getMessage().substring(0, 200) : e.getMessage()));
            return resultBean;
        }
        map.put("list", queryList);
        map.put("pageNum", page.getPageNum());
        map.put("total", page.getTotal());
        map.put("pages", page.getPages());
        resultBean.setMessage(JSON.toJSONString(map));
        resultBean.setResult(Constants.RESULT_SUCCESS);
        return resultBean;
    }
}
