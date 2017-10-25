package com.lmzqm.mybatis.Enum;

/**
 * Created by lmzqm on 2017/8/11.
 */
public enum FocusStatueEnum {
    NO_FOCUS(0,"未关注"),
    FOCUS(1,"已关注"),
    TOO_FOCUS(2,"互相关注");

    private Integer id;
    private String desc;

    FocusStatueEnum(Integer id,String desc){
        this.id = id;
        this.desc = desc;
    }

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
