package com.lmzqm.mybatis.Entity;

import java.io.Serializable;

/**
 * Created by lmzqm on 2017/8/28.
 */
public class Question implements Serializable {

    private Integer questionId;
    private String title;
    private String options;
    private Integer current;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }
}
