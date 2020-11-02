package com.yzf.dao.system.role;

import javax.management.relation.Role;
import java.util.List;

public interface IRoleDao {
    List<Role> findAll();
}
