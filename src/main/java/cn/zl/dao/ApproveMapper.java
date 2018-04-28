package cn.zl.dao;

import cn.zl.domain.Approve;
import cn.zl.domain.ApproveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApproveMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_approve
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int countByExample(ApproveExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_approve
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int deleteByExample(ApproveExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_approve
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int deleteByPrimaryKey(String card);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_approve
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int insert(Approve record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_approve
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int insertSelective(Approve record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_approve
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    List<Approve> selectByExample(ApproveExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_approve
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    Approve selectByPrimaryKey(String card);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_approve
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int updateByExampleSelective(@Param("record") Approve record, @Param("example") ApproveExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_approve
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int updateByExample(@Param("record") Approve record, @Param("example") ApproveExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_approve
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int updateByPrimaryKeySelective(Approve record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_approve
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int updateByPrimaryKey(Approve record);
}