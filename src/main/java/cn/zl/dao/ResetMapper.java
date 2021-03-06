package cn.zl.dao;

import cn.zl.domain.Reset;
import cn.zl.domain.ResetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResetMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_reset
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int countByExample(ResetExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_reset
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int deleteByExample(ResetExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_reset
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int deleteByPrimaryKey(String username);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_reset
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int insert(Reset record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_reset
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int insertSelective(Reset record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_reset
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    List<Reset> selectByExample(ResetExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_reset
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    Reset selectByPrimaryKey(String username);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_reset
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int updateByExampleSelective(@Param("record") Reset record, @Param("example") ResetExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_reset
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int updateByExample(@Param("record") Reset record, @Param("example") ResetExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_reset
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int updateByPrimaryKeySelective(Reset record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_reset
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int updateByPrimaryKey(Reset record);
}