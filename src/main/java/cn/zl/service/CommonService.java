package cn.zl.service;

import cn.zl.domain.extend.CaseExtend;
import cn.zl.pojo.Detail;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author ZL.
 * @project Graduation
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/4/9 17:03
 * @des 公用业务类
 */

public interface CommonService {
    /**
     * 查询信用卡工单信息
     */
    List getCase(CaseExtend cases, PageInfo pageInfo) throws Exception;

    /**
     * 按卡号查询详细信息
     */
    Detail getDetail(String card) throws Exception;
}
