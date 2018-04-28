package cn.zl.domain;

import java.math.BigDecimal;

public class Credit {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column db_credit.id
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column db_credit.name
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column db_credit.delay
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    private Integer delay;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column db_credit.debt
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    private BigDecimal debt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column db_credit.total
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    private Integer total;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column db_credit.money
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    private BigDecimal money;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column db_credit.id
     *
     * @return the value of db_credit.id
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column db_credit.id
     *
     * @param id the value for db_credit.id
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column db_credit.name
     *
     * @return the value of db_credit.name
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column db_credit.name
     *
     * @param name the value for db_credit.name
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column db_credit.delay
     *
     * @return the value of db_credit.delay
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    public Integer getDelay() {
        return delay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column db_credit.delay
     *
     * @param delay the value for db_credit.delay
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column db_credit.debt
     *
     * @return the value of db_credit.debt
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    public BigDecimal getDebt() {
        return debt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column db_credit.debt
     *
     * @param debt the value for db_credit.debt
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    public void setDebt(BigDecimal debt) {
        this.debt = debt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column db_credit.total
     *
     * @return the value of db_credit.total
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column db_credit.total
     *
     * @param total the value for db_credit.total
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column db_credit.money
     *
     * @return the value of db_credit.money
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column db_credit.money
     *
     * @param money the value for db_credit.money
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}