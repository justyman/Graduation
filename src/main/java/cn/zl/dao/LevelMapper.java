package cn.zl.dao;

import cn.zl.domain.Level;
import cn.zl.domain.LevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LevelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_level
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int countByExample(LevelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_level
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int deleteByExample(LevelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_level
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int deleteByPrimaryKey(Integer level);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_level
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int insert(Level record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_level
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int insertSelective(Level record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_level
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    List<Level> selectByExample(LevelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_level
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    Level selectByPrimaryKey(Integer level);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_level
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int updateByExampleSelective(@Param("record") Level record, @Param("example") LevelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_level
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int updateByExample(@Param("record") Level record, @Param("example") LevelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_level
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int updateByPrimaryKeySelective(Level record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_level
     *
     * @mbggenerated Fri Apr 27 18:04:00 CST 2018
     */
    int updateByPrimaryKey(Level record);
}