package cn.zl.pojo;

import com.github.pagehelper.PageInfo;

/**
 * @author ZL.
 * @project Graduation
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/4/10 18:20
 * @des 查询工单Bean
 */
public class QueryCaseBean extends PageInfo {
    /***
     * 页面传来的查询条件参数
     */
    private String card;
    private String id;
    private String channel;
    private String status;
    private String deadline;

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

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
