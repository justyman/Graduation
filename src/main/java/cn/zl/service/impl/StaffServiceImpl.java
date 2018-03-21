package cn.zl.service.impl;

import cn.zl.dao.StaffMapper;
import cn.zl.domain.Staff;
import cn.zl.domain.StaffExample;
import cn.zl.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZL.
 * @project Graduation
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/3/21 17:52
 * @des 请在此处描述
 */
@Service
public class StaffServiceImpl implements StaffService{
    @Autowired
    private StaffMapper staffMapper;
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
}
