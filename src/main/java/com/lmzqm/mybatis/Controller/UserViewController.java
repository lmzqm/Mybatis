package com.lmzqm.mybatis.Controller;

import com.lmzqm.mybatis.Entity.User;
import com.lmzqm.mybatis.Enum.SexEnum;
import com.lmzqm.mybatis.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

/**
 * Created by lmzqm on 2017/6/21.
 */
@RestController
@RequestMapping("/users")
public class UserViewController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{id}")
    public User getUserInfoById(@PathVariable("id") Integer id){

        User user = userMapper.getUserById(id);
        if (user != null){


        }

        EnumSet<SexEnum> sexSet = EnumSet.range(SexEnum.MAN,SexEnum.WOMAN);

        Map<SexEnum,Object> map = new EnumMap<SexEnum,Object>(SexEnum.class);
        map.put(SexEnum.MAN,"这是一个男人");
        map.put(SexEnum.WOMAN,"这是一个女人");



        switch (user.getSex()){

            case MAN:

                break;
            case WOMAN:

                break;
            default:
                break;
        }

        return user;

    }

    @GetMapping("/add")
    public String addUserInfo(){

        User user = new User();
        user.setUserName("lmzqm");
        user.setPassWord("123456");
        user.setSex(SexEnum.MAN);
        user.setNickName("xiaoming");
        Integer id =  userMapper.addUserInfo(user);

        return id.toString();
    }
}
