package com.lmzqm.mybatis.Controller;

import com.lmzqm.mybatis.Entity.ErrorInfo;
import com.lmzqm.mybatis.Entity.User;
import com.lmzqm.mybatis.Enum.SexEnum;
import com.lmzqm.mybatis.Exception.MyException;
import com.lmzqm.mybatis.Mapper.UserMapper;
import com.lmzqm.mybatis.Server.MailServer;
import com.lmzqm.mybatis.Server.PushServer;
import com.lmzqm.mybatis.Server.TokenServer;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lmzqm on 2017/6/21.
 */
@RestController
@RequestMapping(value = "/users")
public class UserViewController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MailServer mailServer;

    @Autowired
    private PushServer pushServer;

    @Autowired
    private TokenServer tokenServer;

    private static Logger logger = LoggerFactory.getLogger(UserViewController.class);

    @GetMapping("/{id}")
    public User getUserInfoById(@PathVariable("id") Integer id){

        User user = userMapper.getUserById(id);
        if (user != null){

            return user;

        }else{
            return new User();
        }

//        EnumSet<SexEnum> sexSet = EnumSet.range(SexEnum.MAN,SexEnum.WOMAN);

//        Map<SexEnum,Object> map = new EnumMap<SexEnum,Object>(SexEnum.class);
//        map.put(SexEnum.MAN,"这是一个男人");
//        map.put(SexEnum.WOMAN,"这是一个女人");



//        switch (user.getSex()){
//
//            case MAN:
//
//                break;
//            case WOMAN:
//
//                break;
//            default:
//                break;
//        }

//        return user;

    }

    @PostMapping("/add")
    @CrossOrigin(methods = {RequestMethod.GET,RequestMethod.POST},origins = "*")
    public String addUserInfo(@ModelAttribute User user1){
        logger.info("add UserInfo"+user1.toString());
        User user = new User();
        user.setUserName("lmzqm");
        user.setPassWord("123456");
        user.setSex(SexEnum.MAN);
        user.setNickName("xiaoming");
        Integer id =  userMapper.addUserInfo(user);

        return id.toString();
    }

    @GetMapping("/mail")
    public String sendMain(){
        logger.info("sendMail start");
        mailServer.sendSimpleMail();
//        mailServer.sendFileMail();
//        mailServer.sendHtmlMail();

        return "success";
    }

    @GetMapping("/push")
    public String pushNotification(){
        pushServer.pushWithPayload();
        return "success";
    }

    @GetMapping("/json")
    public String jsonError() throws MyException {
        throw new MyException("发生错误");
    }

    @GetMapping("/token")
    public String getToken(){
        Map<String,Object> claim = new HashMap<>();
        claim.put("userName","lmzqm");
        claim.put("userId",123);
        logger.info("the claim is "+claim);
        String token = tokenServer.getToken(claim);
        logger.info("the token is "+token);
        if(token == null || token.equals("")){
            return null;
        }
        return token;
    }

    @GetMapping("/prase")
    public void praseToken(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyTmFtZSI6ImxtenFtIiwidXNlcklkIjoxMjN9.BsOjyJ_XuLWH5iSGYGOZ-4w87q_ufUzHegcFcctJ7D8";
        Claims claims =  tokenServer.praseToken(token);
        logger.info("the claims id"+claims.toString());
    }

}
