package cn.zl.service.impl;

import cn.zl.dao.UserMapper;
import cn.zl.po.Staff;
import cn.zl.service.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ZL.
 * @project CreditCard
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/1/24 11:04
 * @des 请在此处描述
 */
@Service
public class UserImpl implements User {
    @Resource
    private UserMapper userMapper;

    public Staff getUser(String username) {
        return userMapper.selectStaff(username);
    }
}
