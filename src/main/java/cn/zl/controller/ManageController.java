package cn.zl.controller;

import cn.zl.domain.Log;
import cn.zl.domain.Notice;
import cn.zl.domain.Staff;
import cn.zl.pojo.QueryLogBean;
import cn.zl.pojo.QueryStaffBean;
import cn.zl.pojo.ResultBean;
import cn.zl.service.impl.ManageServiceImpl;
import cn.zl.utils.Constants;
import cn.zl.utils.PropertiesUtil;
import cn.zl.utils.SessionUtil;
import cn.zl.utils.StringUtil;
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
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZL.
 * @project Graduation
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/4/4 16:06
 * @des 管理员模块
 */
@Controller
public class ManageController {
    private static final Logger log = Logger.getLogger("OPERATION");

    @Resource
    private ManageServiceImpl manageService;

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

    /**
     * 跳转至公告管理页面
     */
    @RequestMapping("noticeManage")
    public ModelAndView noticeManage(){
        return new ModelAndView("manage/notices");
    }

    /**
     * 按条件分页查询系统用户信息结果
     * 每次查询默认分页：每页记录数10，显示第一页数据
     */
    @RequestMapping("queryStaff")
    @ResponseBody
    public ResultBean queryCase(@RequestBody QueryStaffBean queryStaffBean){
        MDC.put("username", ((Staff) SessionUtil.getStaffSession()).getUsername());
        ResultBean resultBean = new ResultBean();
        PageInfo pageInfo = new PageInfo();
        Staff staff = new Staff();
        Map<String, Object> map = new HashMap<String, Object>();
        Page page;
        List queryList;
        if(StringUtil.isEmpty(queryStaffBean.getPosition())){
            queryStaffBean.setPosition("-1");
        }
        try {
            BeanUtils.copyProperties(staff, queryStaffBean);
            BeanUtils.copyProperties(pageInfo, queryStaffBean);
            queryList = manageService.queryStaffs(staff, pageInfo);
            page = (Page)queryList;
        } catch (Exception e) {
            resultBean.setResult(Constants.RESULT_FAILURE);
            log.info("查询用户信息异常：" + (e.getMessage().length() > 200 ? e.getMessage().substring(0, 200) : e.getMessage()));
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
     * 按条件分页查询系统日志信息
     */
    @RequestMapping("queryLog.do")
    @ResponseBody
    public ResultBean queryLog(@RequestBody QueryLogBean queryLogBean){
        MDC.put("username", ((Staff) SessionUtil.getStaffSession()).getUsername());
        ResultBean resultBean = new ResultBean();
        PageInfo pageInfo = new PageInfo();
        Log logs = new Log();
        Map<String, Object> map = new HashMap<String, Object>();
        Page page;
        List queryList;
        try {
            BeanUtils.copyProperties(logs, queryLogBean);
            BeanUtils.copyProperties(pageInfo, queryLogBean);
            queryList = manageService.queryLogs(logs, pageInfo);
            page = (Page)queryList;
        } catch (Exception e) {
            resultBean.setResult(Constants.RESULT_FAILURE);
            log.info("查询日志信息异常：" + (e.getMessage().length() > 200 ? e.getMessage().substring(0, 200) : e.getMessage()));
            return resultBean;
        }
        if(queryList == null){
            resultBean.setResult(Constants.RESULT_SUCCESS);
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
     * 查询公告信息
     */
    @RequestMapping("queryNotice")
    @ResponseBody
    public ResultBean queryNotice(){
        ResultBean resultBean = new ResultBean();
        List<Notice> noticeList = manageService.queryNotice();
        resultBean.setResult(Constants.RESULT_SUCCESS);
        resultBean.setMessage(JSON.toJSONString(noticeList));
        return resultBean;
    }

    /**
     * 冻结用户
     */
    @RequestMapping("freezeStaff.do")
    @ResponseBody
    public ResultBean freezeStaff(String username){
        MDC.put("username", ((Staff) SessionUtil.getStaffSession()).getUsername());
        ResultBean resultBean = new ResultBean();
        try {
            manageService.freezeStaff(username);
        } catch (Exception e) {
            resultBean.setResult(Constants.RESULT_FAILURE);
            log.info("冻结用户失败：" + (e.getMessage().length() > 200 ? e.getMessage().substring(0, 200) : e.getMessage()));
            return resultBean;
        }
        log.info("冻结用户{" + username + "}成功");
        resultBean.setResult(Constants.RESULT_SUCCESS);
        return resultBean;
    }

    /**
     * 解冻用户
     */
    @RequestMapping("normalStaff.do")
    @ResponseBody
    public ResultBean normalStaff(String username){
        MDC.put("username", ((Staff) SessionUtil.getStaffSession()).getUsername());
        ResultBean resultBean = new ResultBean();
        try {
            manageService.normalStaff(username);
        } catch (Exception e) {
            resultBean.setResult(Constants.RESULT_FAILURE);
            log.info("解冻用户失败：" + (e.getMessage().length() > 200 ? e.getMessage().substring(0, 200) : e.getMessage()));
            return resultBean;
        }
        log.info("解冻用户{" + username + "}成功");
        resultBean.setResult(Constants.RESULT_SUCCESS);
        return resultBean;
    }

    /**
     * 修改用户职位
     */
    @RequestMapping("changePosition.do")
    @ResponseBody
    public ResultBean changePosition(String username, int position){
        MDC.put("username", ((Staff) SessionUtil.getStaffSession()).getUsername());
        ResultBean resultBean = new ResultBean();
        try {
            manageService.changePosition(username, position);
        } catch (Exception e) {
            resultBean.setResult(Constants.RESULT_FAILURE);
            log.info("修改用户职位失败：" + (e.getMessage().length() > 200 ? e.getMessage().substring(0, 200) : e.getMessage()));
            return resultBean;
        }
        try {
            log.info("修改用户{" + username + "}职位成功，当前职位为" + PropertiesUtil.getProperty(String.valueOf(position)));
        } catch (Exception e) {
            log.info("配置文件读取异常");
        }
        resultBean.setResult(Constants.RESULT_SUCCESS);
        return resultBean;
    }

    /**
     * 新增公告信息
     */
    @RequestMapping("addNotice.do")
    @ResponseBody
    public ResultBean addNotice(@RequestBody Notice notice){
        MDC.put("username", ((Staff) SessionUtil.getStaffSession()).getUsername());
        ResultBean resultBean = new ResultBean();
        manageService.addNotice(notice);
        log.info("新增公告信息{"+notice.getType()+"}内容{"+notice.getContent()+"}");
        resultBean.setResult(Constants.RESULT_SUCCESS);
        return resultBean;
    }

    /**
     * 删除公告信息
     */
    @RequestMapping("delNotice.do")
    @ResponseBody
    public ResultBean delNotice(int id){
        MDC.put("username", ((Staff) SessionUtil.getStaffSession()).getUsername());
        ResultBean resultBean = new ResultBean();
        Notice notice = manageService.delNotice(id);
        log.info("删除公告信息{"+notice.getType()+"}内容{"+notice.getContent()+"}");
        resultBean.setResult(Constants.RESULT_SUCCESS);
        return resultBean;
    }
}
