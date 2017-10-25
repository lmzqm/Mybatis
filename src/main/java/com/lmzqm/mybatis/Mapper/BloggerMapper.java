package com.lmzqm.mybatis.Mapper;

import com.lmzqm.mybatis.Entity.Blogger;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by lmzqm on 2017/8/7.
 */
@Mapper
public interface BloggerMapper {

    Integer addBlogger(Blogger blogger);
}
