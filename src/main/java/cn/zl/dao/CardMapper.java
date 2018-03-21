package cn.zl.dao;

import cn.zl.domain.Card;
import cn.zl.domain.CardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CardMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_card
     *
     * @mbggenerated Wed Mar 21 17:48:56 CST 2018
     */
    int countByExample(CardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_card
     *
     * @mbggenerated Wed Mar 21 17:48:56 CST 2018
     */
    int deleteByExample(CardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_card
     *
     * @mbggenerated Wed Mar 21 17:48:56 CST 2018
     */
    int deleteByPrimaryKey(String card);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_card
     *
     * @mbggenerated Wed Mar 21 17:48:56 CST 2018
     */
    int insert(Card record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_card
     *
     * @mbggenerated Wed Mar 21 17:48:56 CST 2018
     */
    int insertSelective(Card record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_card
     *
     * @mbggenerated Wed Mar 21 17:48:56 CST 2018
     */
    List<Card> selectByExample(CardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_card
     *
     * @mbggenerated Wed Mar 21 17:48:56 CST 2018
     */
    Card selectByPrimaryKey(String card);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_card
     *
     * @mbggenerated Wed Mar 21 17:48:56 CST 2018
     */
    int updateByExampleSelective(@Param("record") Card record, @Param("example") CardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_card
     *
     * @mbggenerated Wed Mar 21 17:48:56 CST 2018
     */
    int updateByExample(@Param("record") Card record, @Param("example") CardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_card
     *
     * @mbggenerated Wed Mar 21 17:48:56 CST 2018
     */
    int updateByPrimaryKeySelective(Card record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_card
     *
     * @mbggenerated Wed Mar 21 17:48:56 CST 2018
     */
    int updateByPrimaryKey(Card record);
}