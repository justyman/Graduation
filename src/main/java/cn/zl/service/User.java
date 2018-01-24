package cn.zl.service;

import cn.zl.po.Staff;

/**
 * @author ZL.
 * @project CreditCard
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/1/24 11:03
 * @des 请在此处描述
 */
public interface User {
    Staff getUser(String username);
}
