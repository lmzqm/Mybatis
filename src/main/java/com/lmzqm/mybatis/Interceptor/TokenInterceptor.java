package com.lmzqm.mybatis.Interceptor;

import com.lmzqm.mybatis.Annortation.Authorization;
import com.lmzqm.mybatis.Server.TokenServer;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by lmzqm on 2017/7/25.
 */
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenServer tokenServer;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {


        if(!(o instanceof HandlerMethod)){
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod)o;
        Method method = handlerMethod.getMethod();

//        首先从header中获取token
        String authorization = httpServletRequest.getHeader("authorization");
        Claims claims = tokenServer.praseToken(authorization);

        //这里可以获取到相关的用户信息，那我们如何确定这里的信息和我们最后确定的信息是否完全一致呢？还是说这个token已经失效了呢？

        Boolean isCheck =  tokenServer.checkClaims(claims);
        if(isCheck){
            //如果校验成功的话，可以将用户的信息一起放入到参数中，进行一并的操作
            httpServletRequest.setAttribute("userId",claims.get("userId"));
            return true;
        }

//        如果验证失败的话，需要返回一个错误码 让其重新登录
        if(method.getAnnotation(Authorization.class) != null){
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
