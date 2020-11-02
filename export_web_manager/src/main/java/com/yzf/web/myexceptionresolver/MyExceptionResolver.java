package com.yzf.web.myexceptionresolver;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionResolver implements HandlerExceptionResolver {


    public ModelAndView resolveException(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o, Exception e) {


        ModelAndView mv = new ModelAndView();

        mv.addObject("exception",e.getMessage());//添加异常信息
        mv.setViewName("error");//指定一个显示错误的美观页面


        return mv;


    }
}
