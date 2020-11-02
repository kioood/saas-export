package com.yzf.service.system.role.impl;

import com.yzf.dao.system.role.IRoleDao;
import com.yzf.service.system.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    IRoleDao iRoleDao;

    public List<Role> findRole() {

        List<Role> list = iRoleDao.findAll();

        return list;
    }
}
