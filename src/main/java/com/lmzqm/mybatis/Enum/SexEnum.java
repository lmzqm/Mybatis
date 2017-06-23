package com.lmzqm.mybatis.Enum;

/**
 * Created by lmzqm on 2017/6/21.
 */
public enum SexEnum {
    MAN(0,"男"),
    WOMAN(1,"女");

    private Integer sexId;
    private String  desc;

    private SexEnum(Integer sexId, String desc) {
        this.sexId = sexId;
        this.desc = desc;
    }

    public Integer getSexId() {
        return sexId;
    }

    public void setSexId(Integer sexId) {
        this.sexId = sexId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "SexEnum{" +
                "sexId=" + sexId +
                ", desc='" + desc + '\'' +
                '}';
    }
}
