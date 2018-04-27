package cn.zl.pojo;

import com.github.pagehelper.PageInfo;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author ZL.
 * @project Graduation
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/4/27 10:02
 * @des 日志查询bean
 */
public class QueryLogBean extends PageInfo{
    private String username;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
