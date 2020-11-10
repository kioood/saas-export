package com.yzf.web.controller.home;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping(path = "/toMain",method = RequestMethod.GET)
    public String main(){

        return "home/main";

    }
    @RequestMapping(path = "/home",method = {RequestMethod.GET,RequestMethod.POST})
    public String home(){

        return "welcome";

    }
}
