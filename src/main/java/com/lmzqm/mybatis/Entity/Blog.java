package com.lmzqm.mybatis.Entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lmzqm on 2017/8/4.
 */
public class Blog implements Serializable{

    private Integer id;
    private String title;
    private String content;
    private Date time;
    private Integer bloggerId;

    public Integer getBloggerId() {
        return bloggerId;
    }

    public void setBloggerId(Integer bloggerId) {
        this.bloggerId = bloggerId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
