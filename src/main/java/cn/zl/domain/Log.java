package cn.zl.domain;

import java.util.Date;

public class Log {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column db_log.id
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column db_log.time
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    private Date time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column db_log.username
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column db_log.message
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    private String message;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column db_log.id
     *
     * @return the value of db_log.id
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column db_log.id
     *
     * @param id the value for db_log.id
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column db_log.time
     *
     * @return the value of db_log.time
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column db_log.time
     *
     * @param time the value for db_log.time
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column db_log.username
     *
     * @return the value of db_log.username
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column db_log.username
     *
     * @param username the value for db_log.username
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column db_log.message
     *
     * @return the value of db_log.message
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    public String getMessage() {
        return message;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column db_log.message
     *
     * @param message the value for db_log.message
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    public void setMessage(String message) {
        this.message = message;
    }
}