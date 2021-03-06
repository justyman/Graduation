package cn.zl.service;

import cn.zl.domain.Log;
import cn.zl.domain.Notice;
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
     * 按条件查询日志信息
     */
    List<Log> queryLogs(Log logs, PageInfo pageInfo);

    /**
     * 查询公告信息
     */
    List<Notice> queryNotice();

    /**
     * 冻结指定用户
     */
    void freezeStaff(String username) throws Exception;

    /**
     * 解冻指定用户
     */
    void normalStaff(String username) throws Exception;

    /**
     * 修改指定用户职位
     */
    void changePosition(String username, int position) throws Exception;

    /**
     * 新增公告信息
     */
    void addNotice(Notice notice);

    /**
     * 删除公告信息
     */
    Notice delNotice(int id);
}
