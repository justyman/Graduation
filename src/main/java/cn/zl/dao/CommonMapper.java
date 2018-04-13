package cn.zl.dao;

import cn.zl.domain.extend.CaseExtend;
import cn.zl.pojo.Detail;

import java.util.List;

/**
 * @author ZL.
 * @project Graduation
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/4/9 17:22
 * @des 公用的Mapper
 */
public interface CommonMapper {
    /**
     * 按条件查询信用卡工单信息
     */
    List<CaseExtend> selectCases(CaseExtend cases);

    /**
     * 按卡号查询详细信息
     */
    List<Detail> selectDetail(String card);
}
