package cn.zl.utils;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author ZL.
 * @project Graduation
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/3/23 18:23
 * @des 获取properties文件工具类
 */
public class PropertiesUtil {
    /**
     * 通过key得到配置文件对应的value
     */
    public static String getProperty(String key) throws Exception {
        return getProperties().getProperty(key);
    }

    /**
     * 读取配置文件
     */
    private static Properties getProperties() throws Exception {
        InputStream inputStream = null;
        Resource resource = new DefaultResourceLoader().getResource("data.properties");
        try {
            inputStream = resource.getInputStream();
        } catch (IOException e) {
            throw new Exception("配置文件读取失败");
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties;
    }
}
