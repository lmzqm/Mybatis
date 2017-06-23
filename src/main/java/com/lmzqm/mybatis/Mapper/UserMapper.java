package com.lmzqm.mybatis.Mapper;

import com.lmzqm.mybatis.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lmzqm on 2017/6/21.
 */
@Mapper
public interface UserMapper {

     User getUserById(@Param("id") Integer id);

     Integer addUserInfo(User user);
}
