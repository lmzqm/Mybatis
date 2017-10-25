package com.lmzqm.mybatis.Server;

import com.lmzqm.mybatis.Entity.Blog;
import com.lmzqm.mybatis.Entity.BlogDetail;
import com.lmzqm.mybatis.Entity.Blogger;
import com.lmzqm.mybatis.Entity.CommentDetail;
import com.lmzqm.mybatis.Mapper.BlogMapper;
import com.lmzqm.mybatis.Mapper.BloggerMapper;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lmzqm on 2017/8/7.
 */
@Service
public class BlogServer {

    /**
     * 数据处理的操作
     *
     * 首先通过Mybatis中的数据操作，从数据库中获取数据，然后再从数据库的数据进行一些数据的操作，然后再来进行对相应结果的输出操作，
     * 这样的话，压力就不会全部都在数据库当中了，数据库只要做一些简单的操作就可以实现针对特定 请求的实现了
     *
     *
     *
     */

    private static Logger logger = LoggerFactory.getLogger(BlogServer.class);

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private BloggerMapper bloggerMapper;

    public List<Blog> getBlogList(){
        return blogMapper.getBlogList();
    }

    public BlogDetail getBlogDetail(@Param("id") Integer id){
        logger.error("getBlogDetail(@Param(\"id\") Integer id)");
       BlogDetail res = blogMapper.getBlogDatail(id);
        logger.error(res.toString());
        if(res == null){
            logger.error("the result is null");
        }else {
            logger.error(res.toString());
           List<CommentDetail> detail = blogMapper.getCommentList(id);
           if(!detail.isEmpty()){
               res.setComments(detail);

           }else{
               res.setComments(new ArrayList<>());
               logger.error("the result is null");
           }
           return res;
        }
         return new BlogDetail();
    }

    public Blogger addNewBlogger(Blogger blogger){
       Integer id =  bloggerMapper.addBlogger(blogger);
       logger.error("the blogger id is "+id);
       id = blogger.getId();
       return  blogger;
    }

}
