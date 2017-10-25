package com.lmzqm.mybatis.ArgumentReslover;

import com.lmzqm.mybatis.Annortation.Validation;
import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.thymeleaf.util.ArrayUtils;

import java.util.Arrays;

/**
 * Created by lmzqm on 2017/9/21.
 */
public class ValidArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterAnnotation(Validation.class) != null;
//        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {

        Validation validation = methodParameter.getParameterAnnotation(Validation.class);

        String parameter = methodParameter.getParameterName();

        String parameterType = methodParameter.getParameterType().getName();

        String value = nativeWebRequest.getParameter(parameter);

        this.validate(validation,parameter,parameterType,value);

        return null;
    }

    private Object validate(Validation validation,
                            String parameter,
                            String parameterType,
                            String value) throws IllegalArgumentException{
        if (validation.notNull() && StringUtils.isEmpty(value)){

            throw new IllegalArgumentException(String.format("Requeire parameter '%s' is not present",parameter));


        }

        Object realValue = value;

        if (parameterType.equals("java.lang.Integer")){
            realValue = Integer.valueOf(value);
        }

//        if (ArrayUtils.isEmpty(validation.fixedInteger())) {
//            if(Arrays.binarySearch(validation.fixedInteger(),realValue) < 0 ){
//                throw  new IllegalArgumentException(
//                        String.format("Parameter '%s' must in %s",parameter,Arrays.toString(validation.fixedInteger()))
//                );
//            }
//        }

        if (validation.min() != -1 ){

        }

        return realValue;

    }
}
