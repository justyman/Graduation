package cn.zl.service.impl;

import cn.zl.dao.CommonMapper;
import cn.zl.domain.extend.CaseExtend;
import cn.zl.pojo.Detail;
import cn.zl.service.CommonService;
import cn.zl.utils.Constants;
import cn.zl.utils.PropertiesUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZL.
 * @project Graduation
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/4/9 17:04
 * @des 公用业务实现类
 */
@Service
public class CommonServiceImpl implements CommonService{
    @Resource
    private CommonMapper commonMapper;

    /**
     * 按条件查询信用卡工单信息
     * @return 查询结果List集合
     */
    public List<CaseExtend> getCase(CaseExtend cases, PageInfo pageInfo) throws Exception{
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        List<CaseExtend> casesList = commonMapper.selectCases(cases);
        for (CaseExtend caseExtend : casesList) {
            // 从配置文件中读取渠道代码对应的渠道名称
            caseExtend.setChannelName(PropertiesUtil.getProperty(caseExtend.getChannel()));
            // 从配置文件中读取工单状态对应的名称
            caseExtend.setStatus(PropertiesUtil.getProperty(Constants.CASE_PREFIX + caseExtend.getStatus()));
        }
        return casesList;
    }

    /**
     * 按卡号查询详细信息
     * @return 详细信息
     */
    public Detail getDetail(String card) throws Exception{
        Detail detail = commonMapper.selectDetail(card).get(0);
        if(detail != null){
            // 从配置文件中读取渠道代码对应的渠道名称
            detail.setChannel(PropertiesUtil.getProperty(detail.getChannel()));
            // 从配置文件中读取工单状态对应的名称
            detail.setStatus(PropertiesUtil.getProperty(Constants.CASE_PREFIX + detail.getStatus()));
        }
        return detail;
    }
}
