package com.lmzqm.mybatis.Server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by lmzqm on 2017/6/29.
 */
@Service
public class MailServer {

    @Autowired
    private JavaMailSender mailSender;

    private static Logger logger = LoggerFactory.getLogger(MailServer.class);

    /**
     * 发送简单邮件
     */
    public void sendSimpleMail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1056532328@qq.com");
        message.setTo("2720312121@qq.com");
        message.setText("测试邮件内容");
        message.setSubject("邮件主题");
        try {
                mailSender.send(message);
        }catch (MailException e){

        }


    }

    /**
     * 发送文件邮件
     */
    public void sendFileMail() {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.setFrom("1056532328@qq.com");
            helper.setTo("2720312121@qq.com");
            helper.setSubject("发送附件");
            helper.setText("有附件的邮件");

            Resource resource = new ClassPathResource("static/images/weixin.jpg");

            File file = resource.getFile();//new FileSystemResource(new File("images/weixin.jpg"));
            helper.addAttachment("附件1.jpg",file);
            helper.addAttachment("附件2.jpg",file);

            mailSender.send(mimeMessage);

            logger.info("send mail successful");
        } catch (MessagingException e) {
            e.printStackTrace();
            logger.info(e.getLocalizedMessage());
        } catch (MailException e){
            e.printStackTrace();
            logger.info(e.getLocalizedMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 发送html邮件
     */
    public void sendHtmlMail(){
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.setFrom("1056532328@qq.com");
            helper.setTo("2720312121@qq.com");
            helper.setSubject("html主题邮件");
            helper.setText("<html><body><img src=\"cid:weixin\"></body></html>",true);

            Resource resource = new ClassPathResource("static/images/weixin.jpg");
            File file = resource.getFile();

            helper.addInline("weixin",file);

            mailSender.send(mimeMessage);

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
