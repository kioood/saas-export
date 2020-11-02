package com.yzf.service.company.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yzf.dao.company.ICompanyDao;
import com.yzf.domain.company.Company;
import com.yzf.service.company.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private ICompanyDao iCompanyDao;

    public List<Company> findAll() {

        List<Company> list = iCompanyDao.findAll();

        return list;
    }

    public void saveCompany(Company company) {

        String id = UUID.randomUUID().toString();
        company.setId(id);
        company.setExpirationDate(new Date());
        iCompanyDao.saveCompany(company);

    }

    public void deleteById(String id) {

        iCompanyDao.delete(id);
    }

    public Company findById(String id) {

        Company company= iCompanyDao.findId(id);

        return company;
    }

    public void updateCompany(Company company) {
        company.setExpirationDate(new Date());
        iCompanyDao.update(company);
    }

    public PageInfo<Company> findPage(Integer currentPage, Integer pageSize) {

        PageHelper.startPage(currentPage,pageSize);

        List<Company> list = iCompanyDao.findAll();

        PageInfo<Company> pi = new PageInfo<Company>(list);

        return pi;
    }

}
