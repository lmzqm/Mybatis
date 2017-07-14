package com.lmzqm.mybatis.Entity;

import io.netty.channel.sctp.nio.NioSctpServerChannel;

/**
 * Created by lmzqm on 2017/7/10.
 */
public class ActivityStatus {

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

    @Override
    public String toString() {
        return "ActivityStatus{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                '}';
    }
}
