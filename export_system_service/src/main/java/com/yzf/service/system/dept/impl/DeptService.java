package com.yzf.service.system.dept.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yzf.dao.system.dept.IDeptDao;
import com.yzf.domain.system.dept.Dept;
import com.yzf.service.system.dept.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService implements IDeptService {

    @Autowired
    private IDeptDao iDeptDao;

    public PageInfo<Dept> findDept(int currentPage, int pageSize, String companyId) {


        PageHelper.startPage(currentPage,pageSize);

        List<Dept> list = iDeptDao.findAll();

        return new PageInfo<Dept>(list);
    }
}
