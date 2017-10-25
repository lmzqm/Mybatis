package com.lmzqm.mybatis.Converters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by lmzqm on 2017/8/9.
 */
public class CustomObjectMapper extends ObjectMapper {
//    更改默认的json的序列化方案

    /**
     * 这里主要的操作是：
     *  使用0/1来替代false/true
     *  通过""代替null
     *  由于@ResponseBody默认使用的是MappingJackson2HttpMessageConverter 只需要将自己实现的ObjectMapper对象传入就可以实现了
     *
     *
     */
    public CustomObjectMapper(){
        super();
        this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
                jsonGenerator.writeString("");
            }
        });

        SimpleModule module = new SimpleModule();
        module.addSerializer(boolean.class, new JsonSerializer<Boolean>() {
            @Override
            public void serialize(Boolean aBoolean, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
                jsonGenerator.writeNumber(aBoolean ? 1:0);
            }
        });
    }
}
