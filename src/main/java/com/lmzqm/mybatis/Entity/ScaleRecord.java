package com.lmzqm.mybatis.Entity;

import com.sun.jmx.snmp.Timestamp;

import java.util.Date;

/**
 * Created by lmzqm on 2017/8/28.
 */
public class ScaleRecord {

    private Integer id;
    private Integer scaleId;
    private Integer scaleScord;
    private String result;
    private Date recordTime;
    private String results;
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScaleId() {
        return scaleId;
    }

    public void setScaleId(Integer scaleId) {
        this.scaleId = scaleId;
    }

    public Integer getScaleScord() {
        return scaleScord;
    }

    public void setScaleScord(Integer scaleScord) {
        this.scaleScord = scaleScord;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
