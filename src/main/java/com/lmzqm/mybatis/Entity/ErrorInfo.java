package com.lmzqm.mybatis.Entity;

import com.lmzqm.mybatis.Enum.HttpCodeEnum;

import java.io.Serializable;

/**
 * Created by lmzqm on 2017/7/5.
 */
public class ErrorInfo<T> implements Serializable{

    private Integer code;
    private String message;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
