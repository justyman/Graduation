package cn.zl.po;

import java.sql.Timestamp;

/**
 * @author ZL.
 * @project CreditCard
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/1/24 10:31
 * @des PO：对应数据库中的表 db_staff
 */
public class Staff {
    private String username;
    private String password;
    private String name;
    private String phone;
    private String status;
    private long count;
    private Timestamp time;
    private long position;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }


    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }


    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }
}
