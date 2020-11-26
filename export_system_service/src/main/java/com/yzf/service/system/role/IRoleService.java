package com.yzf.service.system.role;

import com.github.pagehelper.PageInfo;
import com.yzf.domain.system.role.Role;


import java.util.List;

public interface IRoleService {
//    List<Role> findRole();//自己写的

    PageInfo<Role> findByPage(int curr, int pageSize, String companyId);

    void saveRole(Role role);

    Role findById(String roleId);
    void updateRole(Role role);

    void deleteRole(String roleId);
}
