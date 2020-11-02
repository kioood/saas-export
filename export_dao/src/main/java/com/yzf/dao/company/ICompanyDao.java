package com.yzf.dao.company;

import com.yzf.domain.company.Company;

import java.util.List;

public interface ICompanyDao {

    List<Company> findAll();

    void saveCompany(Company company);

    void delete(String id);

    Company findId(String id);

    void update(Company company);
}
