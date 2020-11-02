package TestCompanyService;


import com.github.pagehelper.PageInfo;
import com.yzf.domain.system.dept.Dept;
import com.yzf.service.system.dept.IDeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-*.xml")
public class TestDeleteCompany {
        Logger log = LoggerFactory.getLogger(TestDeleteCompany.class);
    @Autowired
    private IDeptService iDeptService;

    @Test
    public void test1(){

        int currentPage=1;
        int pageSize=3;
        String companyId="1";
        PageInfo<Dept> pi = iDeptService.findDept(currentPage,pageSize,companyId);
        log.info("list="+pi);
        System.out.println(pi);
    }
}
