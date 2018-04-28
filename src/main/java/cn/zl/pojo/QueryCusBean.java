package cn.zl.pojo;

import com.github.pagehelper.PageInfo;

/**
 * @author ZL.
 * @project Graduation
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/4/28 17:04
 * @des 客户信息查询bean
 */
public class QueryCusBean extends PageInfo{
    private String card;
    private String id;
    private String name;

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
