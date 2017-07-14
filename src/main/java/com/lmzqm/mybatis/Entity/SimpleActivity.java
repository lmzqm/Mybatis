package com.lmzqm.mybatis.Entity;

/**
 * Created by lmzqm on 2017/7/12.
 * 展示首先的活动类别信息的实体类
 * 包含
 *  id
 *  距离 distance
 *  区 district
 *  已经招募人数 recruitedPersonNumber
 *  总人数 recruitPersonNumber
 *  图片的地址 picture
 *  活动名称 name
 *  经度  longtitude
 *  纬度 latitude
 */
public class SimpleActivity {

    private Integer id;

    private Float distance;

    private String district;

    private Integer recruitedPersonNumber;

    private Integer recruitPersonNumber;

    private String picture;

    /**
     * 经度
     */
    private Double longtitude;

    /**
     * 纬度
     */
    private Double latitude;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getRecruitedPersonNumber() {
        return recruitedPersonNumber;
    }

    public void setRecruitedPersonNumber(Integer recruitedPersonNumber) {
        this.recruitedPersonNumber = recruitedPersonNumber;
    }

    public Integer getRecruitPersonNumber() {
        return recruitPersonNumber;
    }

    public void setRecruitPersonNumber(Integer recruitPersonNumber) {
        this.recruitPersonNumber = recruitPersonNumber;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
