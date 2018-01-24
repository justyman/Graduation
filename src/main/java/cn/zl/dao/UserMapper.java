package cn.zl.dao;

import cn.zl.po.Staff;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author ZL.
 * @project CreditCard
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/1/24 10:48
 * @des 用户表接口
 */
@MapperScan
public interface UserMapper {
    Staff selectStaff(String username);
}
