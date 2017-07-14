package com.lmzqm.mybatis.Enum;

/**
 * Created by lmzqm on 2017/7/5.
 */
public enum HttpCodeEnum {
    SUCCESS(0,"请求成功"),
    FAIL(1,"请求失败"),
    UNFIND(-1,"不存在该值");

    private Integer code;
    private String desc;

    HttpCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
