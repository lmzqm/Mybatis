package com.lmzqm.mybatis.Resolver;

import com.lmzqm.mybatis.Annortation.CurrentUser;
import com.lmzqm.mybatis.Entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Constants;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created by lmzqm on 2017/8/3.
 */
public class CurrentUserResolver  implements HandlerMethodArgumentResolver {

    Logger logger = LoggerFactory.getLogger(CurrentUserResolver.class);

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
//        首先先判断传入的参数时不是user同时也还要保证是否有这个注解
        logger.info("进行参数检查操作，判读是否存在CurrentUser的注解操作");
        if(methodParameter.getParameterType().isAssignableFrom(User.class) &&
                methodParameter.hasParameterAnnotation(CurrentUser.class)){
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
//        return null;

        //取出鉴权的时候回存入的登录用户ID
        Long currentUserId = (Long)nativeWebRequest.getAttribute("userId", RequestAttributes.SCOPE_REQUEST);
        if(currentUserId != null){
            return new User();
        }

        return null;//没有的话就报错就可以了，说明存在一定的问题

    }
}
