package com.lmzqm.mybatis.Entity;

import java.io.Serializable;

/**
 * Created by lmzqm on 2017/8/28.
 */
public class ScaleType implements Serializable{
    private Integer id;
    private String desc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
