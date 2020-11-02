package TestCompanyService;


import com.github.pagehelper.PageInfo;
import com.yzf.domain.company.Company;
import com.yzf.service.company.ICompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-*.xml")  //3:创建 spring/applicationContext-tx.xml
    public class TestCompanyService {


        @Autowired
        private ICompanyService service;

        @Test
        public void test01(){
            //1:编写了业务逻辑的测试
            //等号 左边是接口 右边是实现类
            //ICompanyService  service = new CompanyServiceImpl();
            List<Company> list = service.findAll();
            System.out.println(list);
        }

        @Test
        public void test2(){

            Company company = new Company();

        }

        @Test
        public void addtest(){
//public Company(String id, String name, Date expirationDate, String address, String licenseId, String representative, String phone, String companySize, String industry, String remarks, Integer state, Double balance, String city)
            Company company=new Company("id","name",new Date(),"address","licenseld","representative","phone","companySize","industry","remarks",0,10000.0,"city");
            service.saveCompany(company);

        }

        @Test
        public void pagetest(){

        int currentPage = 1;
        int pageSize = 3;

        PageInfo<Company> pi = service.findPage(currentPage,pageSize);

            System.out.println(pi);
        }
    }

