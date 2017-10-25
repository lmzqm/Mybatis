package com.lmzqm.mybatis.Entity;

import java.io.Serializable;

/**
 * Created by lmzqm on 2017/8/28.
 */
public class Scale implements Serializable {

    private Integer scaleId;
    private String title;
    private Integer type;
    private String desc;
    private String questions;
    private Integer status;
    private Integer testPersons;
    private ScaleType typeInfo;

    public ScaleType getTypeInfo() {
        return typeInfo;
    }

    public void setTypeInfo(ScaleType typeInfo) {
        this.typeInfo = typeInfo;
    }

    public Integer getTestPersons() {
        return testPersons;
    }

    public void setTestPersons(Integer testPersons) {
        this.testPersons = testPersons;
    }

    public Integer getScaleId() {
        return scaleId;
    }

    public void setScaleId(Integer scaleId) {
        this.scaleId = scaleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
