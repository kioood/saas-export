package com.yzf.dao.system.dept;

import com.yzf.domain.system.dept.Dept;

import java.util.List;

public interface IDeptDao {
    List<Dept> findAll(String companyId);

    Dept findById(String deptId);

    void update(Dept dept);


    List<Dept> findDept(String companyId);
}
