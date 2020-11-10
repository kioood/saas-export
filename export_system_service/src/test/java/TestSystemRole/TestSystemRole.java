package TestSystemRole;


import com.rabbitmq.tools.json.JSONUtil;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.yzf.service.system.role.IRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.ls.LSOutput;

import javax.management.relation.Role;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-*.xml")
public class TestSystemRole {
    private static final Logger log = LoggerFactory.getLogger(TestSystemRole.class);

    @Autowired
    IRoleService iRoleService;

    @Test
    public void findAll(){

        List<Role> list = iRoleService.findRole();

       log.info("list"+list);

//        System.out.println(list);
    }

    @Test
    public void test2() {

         int i[] = new int[9];

         System.out.println(i[1]);

            String a;
    }
    @Test
    public void test3() {

        int i;

        System.out.println();

    }

}
