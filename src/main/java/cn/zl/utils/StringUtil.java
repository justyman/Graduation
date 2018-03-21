package cn.zl.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ZL.
 * @project Graduation
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/3/20 17:35
 * @des String工具类
 */
public final class StringUtil {
    private static final Logger log = LoggerFactory.getLogger(StringUtil.class);

    /**
     * 判断字符串是否为 null 或是 空串 或是 纯空格字符串
     * @param value
     * @return
     */
    public static boolean isEmpty(String value){
        return value == null || "".equals(value.trim());
    }
}
