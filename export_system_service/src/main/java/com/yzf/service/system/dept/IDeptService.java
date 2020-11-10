package com.yzf.service.system.dept;

import com.github.pagehelper.PageInfo;
import com.yzf.domain.system.dept.Dept;

import java.util.List;

public interface IDeptService {
    PageInfo<Dept> findDept(int currentPage, int pageSizew, String companyId);

    void updateDept(Dept dept);

    Dept findById(String deptId);

    List<Dept> findAll(String companyId);
}
