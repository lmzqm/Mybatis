package com.lmzqm.mybatis.Config;

import com.lmzqm.mybatis.Interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by lmzqm on 2017/6/30.
 */
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {

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
        super.addCorsMappings(registry);
    }
}
