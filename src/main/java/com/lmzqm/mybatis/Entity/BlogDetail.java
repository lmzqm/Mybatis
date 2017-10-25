package com.lmzqm.mybatis.Entity;

import java.util.List;

/**
 * Created by lmzqm on 2017/8/4.
 */
public class BlogDetail extends Blog {

    private List<CommentDetail> comments;
    private Blogger blogger;

    public Blogger getBlogger() {
        return blogger;
    }

    public void setBlogger(Blogger blogger) {
        this.blogger = blogger;
    }

    public List<CommentDetail> getComments() {
        return comments;
    }

    public void setComments(List<CommentDetail> comments) {
        this.comments = comments;
    }
}
