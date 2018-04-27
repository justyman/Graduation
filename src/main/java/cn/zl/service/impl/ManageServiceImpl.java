package cn.zl.service.impl;

import cn.zl.dao.StaffMapper;
import cn.zl.domain.Staff;
import cn.zl.domain.StaffExample;
import cn.zl.service.ManageService;
import cn.zl.utils.Constants;
import cn.zl.utils.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZL.
 * @project Graduation
 * @right Copyright(C) 2018-2028, ZL. All rights reserved
 * @date 2018/4/24 11:23
 * @des 管理员功能实现类
 */
@Service
public class ManageServiceImpl implements ManageService{
    @Resource
    private StaffMapper staffMapper;

    public List<Staff> queryStaffs(Staff staff, PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        StaffExample example = new StaffExample();
        StaffExample.Criteria c = example.createCriteria();
        if(!StringUtil.isEmpty(staff.getUsername())){
            c.andUsernameEqualTo(staff.getUsername());
        }
        if(!StringUtil.isEmpty(staff.getPhone())){
            c.andPhoneEqualTo(staff.getPhone());
        }
        if(!StringUtil.isEmpty(staff.getName())){
            c.andNameLike(staff.getName());
        }
        if(!StringUtil.isEmpty(staff.getStatus())){
            c.andStatusEqualTo(staff.getStatus());
        }
        if(staff.getPosition() != -1){
            c.andPositionEqualTo(staff.getPosition());
        }
        List<Staff> staffList = staffMapper.selectByExample(example);
        return staffList != null && staffList.size() > 0 ? staffList : null;
    }

    public void freezeStaff(String username) throws Exception {
        Staff staff = staffMapper.selectByPrimaryKey(username);
        if(staff == null){
            throw new Exception("用户名不存在！");
        }else if("N".equals(staff.getStatus())){
            throw new Exception("用户已被冻结！");
        }
        staff.setStatus("N");
        staffMapper.updateByPrimaryKey(staff);
    }

    public void normalStaff(String username) throws Exception {
        Staff staff = staffMapper.selectByPrimaryKey(username);
        if(staff == null){
            throw new Exception("用户名不存在！");
        }else if("Y".equals(staff.getStatus())){
            throw new Exception("用户已解冻！");
        }
        staff.setStatus("Y");
        staffMapper.updateByPrimaryKey(staff);
    }

    public void changePosition(String username, int position) throws Exception {
        Staff staff = staffMapper.selectByPrimaryKey(username);
        if(staff == null){
            throw new Exception("用户名不存在！");
        }else if(position == staff.getPosition()){
            throw new Exception("用户已是当前职位");
        }
        staff.setPosition(position);
        staffMapper.updateByPrimaryKey(staff);
    }
}
