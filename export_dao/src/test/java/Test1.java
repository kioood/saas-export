import com.yzf.dao.company.ICompanyDao;
import com.yzf.domain.company.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-dao.xml")
public class Test1{
    @Autowired
    private ICompanyDao iCompanyDao;//=new 实现类()


    @Test
    public void test2(){


    }

    @Test
    public void findAll() {
        System.out.println(iCompanyDao);
        //返回所有的企业
        List<Company> list = iCompanyDao.findAll();
        System.out.println(list);
    }
    }



