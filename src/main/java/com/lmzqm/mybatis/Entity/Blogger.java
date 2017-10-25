package com.lmzqm.mybatis.Entity;

import java.io.Serializable;

/**
 * Created by lmzqm on 2017/8/4.
 */
public class Blogger implements Serializable {

    private Integer id;
    private String name;
    private String password;
    private String profile;
    private String nickName;
    private String sign;
    private String imgUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

//    public Blogger(Integer id, String name, String password, String profile, String nickName, String sign, String imgUrl) {
//        this.id = id;
//        this.name = name;
//        this.password = password;
//        this.profile = profile;
//        this.nickName = nickName;
//        this.sign = sign;
//        this.imgUrl = imgUrl;
//    }
//
//    @Override
//    public String toString() {
//        return "Blogger{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", password='" + password + '\'' +
//                ", profile='" + profile + '\'' +
//                ", nickName='" + nickName + '\'' +
//                ", sign='" + sign + '\'' +
//                ", imgUrl='" + imgUrl + '\'' +
//                '}';
//    }
}
