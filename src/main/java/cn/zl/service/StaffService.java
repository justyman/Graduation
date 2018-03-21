package cn.zl.service;

import cn.zl.domain.Staff;

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
}
