package cn.zl.utils;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZL.
 * @project Graduation
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/3/22 14:48
 * @des ThreadLocal线程安全时间工具类
 */
public class DateUtil {
    private static final Object OBJ = new Object();
    private static Map<String, ThreadLocal<SimpleDateFormat>> patternMap = new HashMap<String, ThreadLocal<SimpleDateFormat>>();
    private DateUtil(){}

    public static SimpleDateFormat getSimpleDateFormat(String pattern){
        if(!patternMap.containsKey(pattern)){
            synchronized (OBJ){
                if(!patternMap.containsKey(pattern)){
                    ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>(){
                        @Override
                        protected SimpleDateFormat initialValue() {
                            return new SimpleDateFormat();
                        }
                    };
                    patternMap.put(pattern, threadLocal);
                }
            }
        }
        return patternMap.get(pattern).get();
    }
}
