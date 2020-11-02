package com.yzf.service.system.dept;

import com.github.pagehelper.PageInfo;
import com.yzf.domain.system.dept.Dept;

public interface IDeptService {
    PageInfo<Dept> findDept(int currentPage, int pageSize, String companyId);
}
