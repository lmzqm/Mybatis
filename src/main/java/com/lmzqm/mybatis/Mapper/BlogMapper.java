package com.lmzqm.mybatis.Mapper;

import com.lmzqm.mybatis.Entity.Blog;
import com.lmzqm.mybatis.Entity.BlogDetail;
import com.lmzqm.mybatis.Entity.CommentDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by lmzqm on 2017/8/4.
 */
@Mapper
public interface BlogMapper {

    /**
     * 添加新的
     * @param blog
     * @return
     */
    Integer addNewBlog(Blog blog);

    /**
     * 更新博客的信息
     * @param blog
     */
    void updateBlog(Blog blog);

    /**
     * 获取博客的列表
     * @return 返回的是博客的列表
     */
    List<Blog> getBlogList();

    /**
     * 获取博客的详情
     * @param id 博客id
     * @return 博客的详情
     */
    BlogDetail getBlogDatail(Integer id);

    List<CommentDetail> getCommentList(Integer id);


}
