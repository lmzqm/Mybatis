package com.lmzqm.mybatis.Interceptor;

import com.lmzqm.mybatis.Annortation.Authorization;
import com.lmzqm.mybatis.Exception.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by lmzqm on 2017/6/30.
 */
public class MyInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws MyException {

        /**
         *  只有返回true 才会继续向下执行，返回false取消当前请求
         */
        logger.info("在请求处理之前调用Handle方法调用前");

        logger.info(httpServletRequest.toString());

//        Integer type = (Integer) httpServletRequest.getSession().getAttribute("userTYpe");
//        if (type == 1){
//            return true;
//        }else{
//            httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
////            httpServletResponse.sendError(HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.getReasonPhrase());
//            return false;
//        }




        return true;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        /**
         *
         */

        logger.info("请求处理之后调用，但是在视图被渲染之前调用，handle方法调用之后");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info("在整个请求结束之后调用，也就是在DispatcherServlet渲染了对应的视图之后执行，主要适用于资源清理工作");
    }
}
