package com.lmzqm.mybatis.Entity;

import com.lmzqm.mybatis.Enum.FocusStatueEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lmzqm on 2017/8/11.
 */
public class Focus implements Serializable{

    private Integer id;
    private Integer userId; //用户ID
    private Integer focusId; //被关注的ID
    private Date time;
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFocusId() {
        return focusId;
    }

    public void setFocusId(Integer focusId) {
        this.focusId = focusId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
