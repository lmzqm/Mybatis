package com.lmzqm.mybatis.Exception;

import com.lmzqm.mybatis.Entity.ErrorInfo;
import com.lmzqm.mybatis.Entity.User;
import com.lmzqm.mybatis.Enum.HttpCodeEnum;
import com.lmzqm.mybatis.Enum.SexEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lmzqm on 2017/7/5.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    public static final String DEFAULT_ERROR_VIEW ="error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req,Exception e){

        logger.info("the req is"+req.toString()+"the error is "+e.toString());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception",e);
        modelAndView.addObject("url",req.getRequestURL());
        modelAndView.setViewName(DEFAULT_ERROR_VIEW);
        return modelAndView;
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<User> jsonErrorHandler(HttpServletRequest req, MyException e){

        ErrorInfo<User> errorInfo = new ErrorInfo<>();
        errorInfo.setCode(HttpCodeEnum.FAIL.getCode());
        errorInfo.setMessage(HttpCodeEnum.FAIL.getDesc());
        User user = new User();
        user.setUserName("lmzqm");
        user.setPassWord("123456");
        user.setSex(SexEnum.MAN);
        user.setNickName("xiaoming");
        errorInfo.setData(user);
        return errorInfo;
    }
}
