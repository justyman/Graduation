package cn.zl.domain;

public class Notice {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column db_notice.id
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column db_notice.type
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column db_notice.content
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column db_notice.id
     *
     * @return the value of db_notice.id
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column db_notice.id
     *
     * @param id the value for db_notice.id
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column db_notice.type
     *
     * @return the value of db_notice.type
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column db_notice.type
     *
     * @param type the value for db_notice.type
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column db_notice.content
     *
     * @return the value of db_notice.content
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column db_notice.content
     *
     * @param content the value for db_notice.content
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    public void setContent(String content) {
        this.content = content;
    }
}