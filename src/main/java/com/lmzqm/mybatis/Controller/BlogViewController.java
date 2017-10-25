package com.lmzqm.mybatis.Controller;

import com.lmzqm.mybatis.Entity.Blog;
import com.lmzqm.mybatis.Entity.BlogDetail;
import com.lmzqm.mybatis.Entity.Blogger;
import com.lmzqm.mybatis.Entity.ResultModel;
import com.lmzqm.mybatis.Enum.HttpCodeEnum;
import com.lmzqm.mybatis.Server.BlogServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by lmzqm on 2017/8/7.
 */
@RestController
@RequestMapping(value = "/blogs")
public class BlogViewController {

    @Autowired
    private BlogServer blogServer;

    private final Logger logger = LoggerFactory.getLogger(BlogViewController.class);


    @GetMapping("/")
    public ResponseEntity<?> getBlogList(){
        logger.info("Hello world");
        List<Blog> blogs = blogServer.getBlogList();
        if(blogs.isEmpty()){
            return  new ResponseEntity<Object>(ResultModel.error(HttpCodeEnum.FAIL),HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<Object>(ResultModel.ok(blogs),HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBlogInfo(@PathVariable("id") Integer id){
        BlogDetail detail = blogServer.getBlogDetail(id);
        if (detail == null){
            return  new ResponseEntity<Object>(ResultModel.error(HttpCodeEnum.UNFIND),HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Object>(ResultModel.ok(detail),HttpStatus.OK);

    }

    @GetMapping("/users")
    public ResponseEntity<?> addBlogger(){
        Blogger blogger = new Blogger();
        blogger.setImgUrl("http://www.baiddddudud.com");
        blogger.setName("hello world");
        blogger.setNickName("hwlwodk");
        blogger.setPassword("dhdhdhdh");
        blogger.setProfile("这只是一个简单的例子");

        Blogger id = blogServer.addNewBlogger(blogger);

        return new ResponseEntity<Object>(ResultModel.ok(id),HttpStatus.OK);
    }

    @GetMapping("/time")
    public ResponseEntity<?> returnNewSwtich(){

//        switch ("a"){
//            case "a":
//
//                break;
//            case "b":
//
//                break;
//            default:
//
//                break;
//        }
//
//        Integer i = Integer.parseInt("10");
//
//        //分割字符串
//        String str = "hello you are ";
//        str.split("\\s+");//"\s" 表示空格 还有如""，" "、t","\r","\n"
//
//        String abc = str.substring(1);
//
//        StringBuffer sb = new StringBuffer("hello");
//
////        快速的复制一端字符串
//        String st = "abc";
//        String repated = StringUtils.repeat(st,3);//这样就复制了 abcabcabc
//
//        String time = "";
//        try {
//            Date date = new SimpleDateFormat("YYYY-mm-dd").parse(time);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
//
//        format.format(new Date());

//        String Date Calendar TimeStamp之间的转换
//        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dateStr = sdf.format(calendar.getTime());
//
//        //Stirng 转换为Calendar
//        String str = "2017-5-27";
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            Date date = format.parse(str);
//            Calendar calendar1 = Calendar.getInstance();
//            calendar1.setTime(date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        //Date转换为Stirng
//
//        String datStr = format.format(new Date());
//
//        //将String转换为 Date
//        try {
//            Date date = format.parse("2017-5-27");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        //String 转成 TimeStamp
//
//        Calendar calendar2 = Calendar.getInstance();
//        calendar2.setTime(new Date());
//        calendar2.add(Calendar.DAY_OF_MONTH,-1);
//        Date date = calendar2.getTime();
//
//        //获取当前的时间戳
//        Timestamp st = new Timestamp(System.currentTimeMillis());
//        Timestamp d = new Timestamp(date.getTime());


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH,1);
        Date date =  calendar.getTime();

        //将date转化为Stirng
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String time = format.format(date);

        try {
            Date dates =  format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        BlogDetail blogger = new BlogDetail();
        blogger.setTime(date);
        blogger.setTitle(time);


        return new ResponseEntity<Object>(ResultModel.ok(blogger),HttpStatus.OK);


    }
}
