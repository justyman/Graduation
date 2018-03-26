package cn.zl.utils;

import cn.zl.domain.Staff;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

/**
 * @author ZL.
 * @project Graduation
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/3/23 16:42
 * @des 管理用户session
 */
public class SessionUtil {
    /**
     * 创建session
     */
    private static Session getSession(){
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * 设置session
     */
    public static void setSessionAttribute(Object key, Object value){
        getSession().setAttribute(key, value);
    }

    /**
     * 获取session
     */
    public static Object getSessionAttribute(Object key){
        return getSession().getAttribute(key);
    }

    /**
     * 清楚session
     */
    public static void removeSessionAttribute(Object key){
        getSession().removeAttribute(key);
    }

    /**
     * 存储用户session
     */
    public static void setStaffSession(Staff staff){
        setSessionAttribute(Constants.STAFF_SESSION_KEY, staff);
    }

    /**
     * 获取用户session
     */
    public static Staff getStaffSession(){
        return (Staff) getSessionAttribute(Constants.STAFF_SESSION_KEY);
    }
}
