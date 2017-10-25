package com.lmzqm.mybatis.Config;

import com.lmzqm.mybatis.Converters.CustomObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;


import javax.servlet.MultipartConfigElement;
import java.io.IOException;
import java.lang.reflect.Type;


/**
 * Created by lmzqm on 2017/7/4.
 */
@Configuration
public class FileUploadConfigurer {

//    @Value("${upload.file}")
//    private String uploadFile;

    private static Logger logger = LoggerFactory.getLogger(FileUploadConfigurer.class);


    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
//        factory.setLocation(uploadFile);
        factory.setMaxFileSize("10MB");
        return factory.createMultipartConfig();

    }

    /***
     * 实现对返回的json的加密操作
     * @return 返回加密后的MessageConverter对象
     *
     *  然后需要在WebAppConfugurer中进行相对应的配置
     */
    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
        return new MappingJackson2HttpMessageConverter(){


            @Override
            protected void writeInternal(Object object, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
                //加密的操作
//                ObjectMapper mapper = new ObjectMapper();
                CustomObjectMapper mapper = new CustomObjectMapper();
                String json = mapper.writeValueAsString(object);
                String result = json+"加米拉";
//                logger.error("the result is "+json);
//                try {
//                    MessageDigest sha1Digest = MessageDigest.getInstance("MD5");
//                    sha1Digest.update(result.getBytes());
//                    byte digets[] = sha1Digest.digest();
//
//                    int bytesLens = digets.length;
//                    StringBuffer hexString = new StringBuffer(bytesLens*2);
//                    for(int i=0;i<bytesLens;i++){
//                        String hex = Integer.toHexString(digets[i]&0xFF);
//                        if(hex.length()<2){
//                            hexString.append(0);
//                        }
//                        hexString.append(hex);
//                    }
//                    outputMessage.getBody().write(hexString.toString().getBytes());
                outputMessage.getBody().write(result.getBytes());

//
//                } catch (NoSuchAlgorithmException e) {
//                    e.printStackTrace();
//                }


            }

//            @Override
//            protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
//                //解密的操作
//                Object obj = inputMessage.getBody();
//                //这里讲这个obj进行界面后，然后再放入到inputMessage中就可以完成解密的操作了
//
//
//                return super.readInternal(clazz, inputMessage);
//            }

        };
    }



}
