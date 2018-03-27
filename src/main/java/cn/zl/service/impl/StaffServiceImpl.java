package cn.zl.service.impl;

import cn.zl.dao.ResetMapper;
import cn.zl.dao.StaffMapper;
import cn.zl.domain.Reset;
import cn.zl.domain.Staff;
import cn.zl.domain.StaffExample;
import cn.zl.pojo.Info;
import cn.zl.pojo.ResultBean;
import cn.zl.service.StaffService;
import cn.zl.utils.Constants;
import cn.zl.utils.PropertiesUtil;
import cn.zl.utils.SessionUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author ZL.
 * @project Graduation
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/3/21 17:52
 * @des 用户功能
 */
@Service
public class StaffServiceImpl implements StaffService{
    private static final Logger log = Logger.getLogger("OPERATION");

    @Autowired
    private StaffMapper staffMapper;

    @Autowired
    private ResetMapper resetMapper;
    /**
     * 员工登陆
     * @param username
     * @param password
     * @return 用户名与密码匹配则返回员工信息，不匹配则返回null
     */
    public Staff login(String username, String password) {
        StaffExample example = new StaffExample();
        StaffExample.Criteria c = example.createCriteria();
        c.andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<Staff> staffs = staffMapper.selectByExample(example);
        return staffs != null && staffs.size() > 0 ? staffs.get(0) : null;
    }

    /**
     * 重置密码
     * @param reset
     * @return 重置成功返回true；失败返回false
     */
    public ResultBean reset(Reset reset) {
        ResultBean resultBean = new ResultBean();

        StaffExample example = new StaffExample();
        StaffExample.Criteria c = example.createCriteria();
        c.andUsernameEqualTo(reset.getUsername());
        List<Staff> staffs = staffMapper.selectByExample(example);

        if(staffs == null || staffs.size() <= 0){
            resultBean.setResult(Constants.RESULT_FAILURE);
            resultBean.setMessage("无效的用户名！");
            return resultBean;
        }

        Staff staff = staffs.get(0);
        reset.setPassword(staff.getPassword());

        if(reset.getPassword().equals(reset.getResetword())){
            resultBean.setResult(Constants.RESULT_FAILURE);
            resultBean.setMessage("重置密码与原密码相同！");
            return resultBean;
        }

        MDC.put("username", reset.getUsername());
        try {
            resetMapper.insert(reset);
            resultBean.setResult(Constants.RESULT_SUCCESS);
            log.info("申请重置密码");
            return resultBean;
        } catch (DuplicateKeyException e){
            resultBean.setResult(Constants.RESULT_FAILURE);
            resultBean.setMessage("您已经申请重置密码，请耐心等待管理员回复");
            return resultBean;
        } catch (Exception e) {
            resultBean.setResult(Constants.RESULT_FAILURE);
            resultBean.setMessage("数据库存储失败！请联系管理员！");
            log.info("保存重置密码信息失败!数据库异常：" +  e.getMessage().substring(0,200));
            return resultBean;
        }
    }

    /**
     * 得到并配置用户信息
     */
    public ResultBean getInfo(Info info){
        ResultBean resultBean = new ResultBean();
        Staff staff = new Staff();
        // 得到用户信息
        try {
            BeanUtils.copyProperties(staff, SessionUtil.getStaffSession());
            BeanUtils.copyProperties(info, SessionUtil.getStaffSession());
        } catch (Exception e) {
            resultBean.setResult(Constants.RESULT_FAILURE);
            log.info("属性copy异常：" + e.getMessage().substring(0, 200));
            return resultBean;
        }
        // 配置用户信息
        try {
            info.setStatus(PropertiesUtil.getProperty(staff.getStatus()));
            info.setPosition(PropertiesUtil.getProperty(staff.getPosition().toString()));
        } catch (Exception e) {
            resultBean.setResult(Constants.RESULT_FAILURE);
            log.info("读取配置文件失败：" + e.getMessage().substring(0, 200));
            return resultBean;
        }
        String birthDate = new SimpleDateFormat("yyyy-MM-dd").format(staff.getBirth());
        String entryDate = new SimpleDateFormat("yyyy-MM-dd").format(staff.getEntry());
        info.setBirth(birthDate);
        info.setEntry(entryDate);

        return resultBean;
    }
}
