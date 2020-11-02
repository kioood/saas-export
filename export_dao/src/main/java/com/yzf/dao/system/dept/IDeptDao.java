package com.yzf.dao.system.dept;

import com.yzf.domain.system.dept.Dept;

import java.util.List;

public interface IDeptDao {
    List<Dept> findAll();
     Dept findById(String deptId);
}
