package com.yzf.service.system.role.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yzf.dao.system.role.IRoleDao;
import com.yzf.domain.system.role.Role;
import com.yzf.service.system.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    IRoleDao iRoleDao;

//    public List<Role> findRole() {
//
//        List<Role> list = iRoleDao.findAll();
//
//        return list;
//    }

    public PageInfo<Role> findByPage(int curr, int pageSize, String companyId) {
        //设置参数
        PageHelper.startPage(curr,pageSize);
        //调用全查
        List<Role> list = iRoleDao.findAll(companyId);
        //包装成PageInfo
        PageInfo<Role> pi = new PageInfo<Role>(list);
        return pi;
    }

    public void saveRole(Role role) {
        String uuid= UUID.randomUUID().toString();
        role.setRoleId(uuid);
        iRoleDao.save(role);
    }


    public Role findById(String roleId) {
        return iRoleDao.findById(roleId);
    }

    public void updateRole(Role role) {
        iRoleDao.update(role);
    }


    public void deleteRole(String roleId) {
        iRoleDao.deleteById(roleId);
    }
}
