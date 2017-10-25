package com.lmzqm.mybatis.Entity;

import com.lmzqm.mybatis.Enum.HttpCodeEnum;

import javax.swing.plaf.PanelUI;
import java.io.Serializable;

/**
 * Created by lmzqm on 2017/7/12.
 */
public class ResultModel implements Serializable{

    private int code;

    private String message;

    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResultModel(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultModel(HttpCodeEnum httpStatus){
        this.code = httpStatus.getCode();
        this.message = httpStatus.getDesc();
        this.data = "";
    }

    public ResultModel(HttpCodeEnum httpStatus ,Object data){
        this.code = httpStatus.getCode();
        this.message  = httpStatus.getDesc();
        this.data = data;
    }

    public static ResultModel ok(Object data){
        return new ResultModel(HttpCodeEnum.SUCCESS,data);
    }

    public static ResultModel ok(){
        return  new ResultModel(HttpCodeEnum.SUCCESS);
    }

    public static ResultModel error(HttpCodeEnum error){
        return new ResultModel(error);
    }


}
