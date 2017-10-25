package com.lmzqm.mybatis.Converters;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.util.List;

/**
 * Created by lmzqm on 2017/8/3.
 */
public class CustomMessageConverter implements HttpMessageConverter {

    /*
    *   自定义HttpMessageConverter对返回的内容进行加密
    *
    *   http://www.scienjus.com/custom-http-message-converter/
    *
    *   在SpringMvc中的Controller层经常会用到@RequestBody和@ResponseBody通过这两个注解，可以在Controller中直接使用Java对象，作为请求参数和返回的内容
    *   然而完成这之间的转换作用便是HttpMessageConverter
    *
    *   httpMessageConverter接口提供了5个方法
    *
    *   canRead ：判断该转换器是否能够将请求的内容转换为java对象
    *   canWrite ； 判断该转换器能够将java对象转换成返回的内容
    *   getSupportedMediaType：获取该转换器支持的MediaType类型
    *   read:读取请求的内容，并将其转换为java对象
    *   write：将java对象转换后写入返回的内容
    *
    *   http://www.scienjus.com/spring-mvc-use-skill/
    *
    *
    *
    *
    * */
    @Override
    public boolean canRead(Class aClass, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class aClass, MediaType mediaType) {
        return false;
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return null;
    }

    @Override
    public Object read(Class aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(Object o, MediaType mediaType, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {

    }
}
