package com.yzf.service.company;


import com.github.pagehelper.PageInfo;
import com.yzf.domain.company.Company;

import java.util.List;


public interface ICompanyService {

     List<Company> findAll();

    void saveCompany(Company company);

    void deleteById(String id);

    Company findById(String id);

    void updateCompany(Company company);

    PageInfo<Company> findPage(Integer currentPage, Integer pageSize);
}
