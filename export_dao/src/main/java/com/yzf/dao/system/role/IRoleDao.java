package com.yzf.dao.system.role;


import com.yzf.domain.system.role.Role;

import java.util.List;

public interface IRoleDao {
//    List<Role> findAll();
    List<Role> findAll(String companyId);

    void save(Role role);

    Role findById(String roleId);
    void update(Role role);

    void deleteById(String roleId);
}
