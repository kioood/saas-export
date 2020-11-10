package com.yzf.web.controller.system.user;

import com.yzf.domain.system.user.User;
import com.yzf.service.system.user.IUserService;
import com.yzf.web.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/system/user")
public class UserController extends BaseController {
    //${path}/system/user/login.do
    //email
    //password
    @Autowired
    IUserService iUserService;

    private Logger l = LoggerFactory.getLogger(this.getClass());
    @RequestMapping(path = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(String email,String password){
        //根据 email查询对应的用户
        l.info("login email "+email);
        l.info("login password "+password);
        User user = iUserService.findUserByEmail(email);
        l.info("login user "+user);
        if (user != null) {
            //1:找到
            //比较账号密码
            if(user.getPassword().equals(password)){
                //正确
                l.info("正确");
                //保存用户信息
                session.setAttribute("loginUser",user);
                //跳到主页
                return "redirect:/home/toMain.do";
            }else{
                //密码不对
                l.info("密码不对");
                request.setAttribute("error","邮箱或者密码不对");
                return "forward:/login.jsp";
            }
        }else{
            //2:没找到
            //用户不存在
            l.info("用户不存在");
            request.setAttribute("error","用户不存在");
            return "forward:/login.jsp";
        }

    }
    @RequestMapping(path = "/loginOut", method = {RequestMethod.GET, RequestMethod.POST})
    public String loginOut(){
        //删除session中的用户信息
        session.removeAttribute("loginUser");
        //让session过期
        session.invalidate();
        return "redirect:/login.jsp";//转发不会改地址的数据，只有重定向会
    }

}
