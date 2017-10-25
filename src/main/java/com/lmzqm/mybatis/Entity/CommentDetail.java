package com.lmzqm.mybatis.Entity;

/**
 * Created by lmzqm on 2017/8/4.
 */
public class CommentDetail extends Comment {

    private Blogger blogger;

    public Blogger getBlogger() {
        return blogger;
    }

    public void setBlogger(Blogger blogger) {
        this.blogger = blogger;
    }
}
