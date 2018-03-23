package cn.zl.service.impl;

import cn.zl.dao.ResetMapper;
import cn.zl.dao.StaffMapper;
import cn.zl.domain.Reset;
import cn.zl.domain.ResetExample;
import cn.zl.domain.Staff;
import cn.zl.domain.StaffExample;
import cn.zl.pojo.ResultBean;
import cn.zl.service.StaffService;
import cn.zl.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private static final Logger log = LoggerFactory.getLogger(StaffServiceImpl.class);

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

        try {
            resetMapper.insert(reset);
            resultBean.setResult(Constants.RESULT_SUCCESS);
            log.info("用户{}申请重置密码", reset.getUsername());
            return resultBean;
        } catch (Exception e) {
            resultBean.setResult(Constants.RESULT_FAILURE);
            resultBean.setMessage("数据库存储失败！请联系管理员！");
            log.info("数据库异常：保存重置密码信息失败{}", e.getMessage());
            return resultBean;
        }
    }
}
