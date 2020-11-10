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

        List<Dept> list = iDeptDao.findAll(companyId);

        return new PageInfo<Dept>(list);
    }

    public void updateDept(Dept dept) {

        dept.setCompanyId("1");
        dept.setCompanyName("吉首大学");

       iDeptDao.update(dept);

    }

    public Dept findById(String deptId) {

        Dept list = iDeptDao.findById(deptId);

        return list;
    }

    public List<Dept> findAll(String companyId) {
        List<Dept> list = iDeptDao.findDept(companyId);
        return list;
    }
}
