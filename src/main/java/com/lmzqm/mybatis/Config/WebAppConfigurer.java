package com.lmzqm.mybatis.Config;

import com.lmzqm.mybatis.Converters.CustomMessageConverter;
import com.lmzqm.mybatis.Interceptor.MyInterceptor;
import com.lmzqm.mybatis.Resolver.CurrentUserResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by lmzqm on 2017/6/30.
 */
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {

    @Autowired
     private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

    /**
     * 添加拦截器的操作
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 添加自定义的拦截器，组成一个拦截器链表
         * addInterceptors用于添加拦截器规则
         * excludePathPatterns 用户排除拦截
         */
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/users/*");
//                .addPathPatterns("/users/push","/user/mail");
//                .excludePathPatterns("/user/*");
//        registry.addInterceptor(new MyInterceptor()).excludePathPatterns();

        super.addInterceptors(registry);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        Cors的全局配置操作
//        registry.addMapping("*")
//                .allowedMethods("GET")
//                .allowCredentials(false);

//        还有一种方案就是是Nginx的方法，来进行配置操作


        super.addCorsMappings(registry);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        //添加参数的的校验
//        argumentResolvers.add(new CurrentUserResolver());

        super.addArgumentResolvers(argumentResolvers);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(mappingJackson2HttpMessageConverter);
        super.configureMessageConverters(converters);
    }
}
