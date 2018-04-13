package cn.zl.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ZL.
 * @project Graduation
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/4/12 18:20
 * @des 工单详细信息实体类
 */
public class Detail {
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String gender;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 身份证
     */
    private String id;
    /**
     * 偿还等级
     */
    private int level;
    /**
     * 信用评分
     */
    private int credit;
    /**
     * 家庭住址
     */
    private String address;
    /**
     * 卡号
     */
    private String card;
    /**
     * 办卡渠道
     */
    private String channel;
    /**
     * 处理期限
     */
    private int deadline;
    /**
     * 业务人员
     */
    private String businessName;
    /**
     * 受理时间
     */
    private Date businessTime;
    /**
     * 卡片状态
     */
    private String status;
    /**
     * 开户日期
     */
    private Date openDate;
    /**
     * 账单日
     */
    private int bill;
    /**
     * 当前额度
     */
    private BigDecimal amount;
    /**
     * 总消费金额
     */
    private BigDecimal money;
    /**
     * 总逾期金额
     */
    private BigDecimal debt;
    /**
     * 逾期次数
     */
    private int delay;
    /**
     * 还款日总次数
     */
    private int total;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Date getBusinessTime() {
        return businessTime;
    }

    public void setBusinessTime(Date businessTime) {
        this.businessTime = businessTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getDebt() {
        return debt;
    }

    public void setDebt(BigDecimal debt) {
        this.debt = debt;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
