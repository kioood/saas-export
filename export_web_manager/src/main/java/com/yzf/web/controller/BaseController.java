package com.yzf.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//子类继承父类，可以自动拥有父类的非私有成员（方法或者变量）
public class BaseController {
    private Logger l = LoggerFactory.getLogger(this.getClass());
    //定义一个可以返回companyId
    public String getLoginCompanyId(){
        return "1";
    }
    //定义一个可以返回companyName
    public String getLoginCompanyName(){
        return "吉首大学";
    }

    @Autowired
    protected HttpSession session;

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;
}
