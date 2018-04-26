package cn.zl.service;

import cn.zl.domain.Staff;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author ZL.
 * @project Graduation
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/4/24 11:21
 * @des 管理员功能
 */
public interface ManageService {
    /**
     * 按条件查询员工信息
     */
    List<Staff> queryStaffs(Staff staff, PageInfo pageInfo);

    /**
     * 冻结指定用户
     */
    void freezeStaff(String username) throws Exception;

    /**
     * 解冻指定用户
     */
    void normalStaff(String username) throws Exception;
}
