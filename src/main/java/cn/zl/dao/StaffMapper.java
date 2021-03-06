package cn.zl.dao;

import cn.zl.domain.Staff;
import cn.zl.domain.StaffExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaffMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_staff
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int countByExample(StaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_staff
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int deleteByExample(StaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_staff
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int deleteByPrimaryKey(String username);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_staff
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int insert(Staff record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_staff
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int insertSelective(Staff record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_staff
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    List<Staff> selectByExample(StaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_staff
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    Staff selectByPrimaryKey(String username);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_staff
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int updateByExampleSelective(@Param("record") Staff record, @Param("example") StaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_staff
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int updateByExample(@Param("record") Staff record, @Param("example") StaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_staff
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int updateByPrimaryKeySelective(Staff record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_staff
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int updateByPrimaryKey(Staff record);
}