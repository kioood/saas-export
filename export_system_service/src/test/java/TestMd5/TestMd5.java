package TestMd5;

import com.yzf.domain.system.user.User;
import com.yzf.service.md5.MD5Utils;
import com.yzf.service.system.user.IUserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext*.xml")
public class TestMd5 {
        private Logger l = LoggerFactory.getLogger(this.getClass());
    @Autowired
    IUserService iUserService;

    @Test
    public void test1(){

        Md5Hash md5 = new Md5Hash("123","yzf");
        System.out.println(md5);
    //7bf345acef830742a3ff6a296bcee88a
    }
    @Test
    public void stringToMD5() {
        String result = MD5Utils.stringToMD5("123yzf");
        System.out.println(result);
     //(123yzf)246e56b34fc11facd4f271c3db61fcbf
    }
    @Test
    public void test06(){
        //根据 email查询对应的用户

        String email = "xiaoer@export.com";
        String password="123";
        User user = iUserService.findUserByEmail(email);
        l.info("test06 user "+user);
        if (user != null) {
            //1:找到
            //比较账号密码
            if(user.getPassword().equals(password)){
                //正确
                l.info("正确");
            }else{
                //密码不对
                l.info("密码不对");
            }
        }else{
            //2:没找到
            //用户不存在
            l.info("用户不存在");
        }
    }
    @Test
    public void test6(){
        int arr[][]={{1,2,2},{2,2,5},{4,4}};
        boolean found =false;
        for(int i=0;i<arr.length&&!found;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {

                if(arr[i][j]==5)
                {
                    System.out.println("i="+i+",j="+j);
                    found=true;
                    break;
                }
            }
        }
    }
}
