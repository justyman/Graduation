package cn.zl.service;

import cn.zl.domain.Reset;
import cn.zl.domain.Staff;
import cn.zl.pojo.ResultBean;

/**
 * @author ZL.
 * @project Graduation
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/3/21 17:52
 * @des
 */
public interface StaffService {
    /**
     * 员工登陆
     */
    Staff login(String username, String password);

    /**
     * 重置密码
     */
    ResultBean reset(Reset reset);
}
