package TestDeptService;


import TestCompanyService.TestDeleteCompany;
import TestSystemRole.TestSystemRole;
import com.yzf.domain.system.dept.Dept;
import com.yzf.service.system.dept.IDeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


public class TestUpdateDept {
    private static final Logger log = LoggerFactory.getLogger(TestUpdateDept.class);
    @Autowired
    IDeptService iDeptService;

    @Test
    public void test1(){
        int i = 81;

       /*This is comment*/
        double d = 8.1;
        char c = 'A';
       Dept list= iDeptService.findById("100101");

        log.info("list="+list);

    }
}
