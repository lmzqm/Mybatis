package com.lmzqm.mybatis.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * Created by lmzqm on 2017/7/4.
 */
@Configuration
public class FileUploadConfigurer {

//    @Value("${upload.file}")
//    private String uploadFile;

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
//        factory.setLocation(uploadFile);
        factory.setMaxFileSize("1MB");
        return factory.createMultipartConfig();

    }
}
