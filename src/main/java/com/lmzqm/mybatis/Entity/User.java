package com.lmzqm.mybatis.Entity;

import com.lmzqm.mybatis.Enum.SexEnum;

import java.io.Serializable;

/**
 * Created by lmzqm on 2017/6/21.
 */
public class User implements Serializable{

    private Integer id;
    private String userName;
    private String passWord;
    private SexEnum sex;
    private String nickName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public User User(){

        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", sex=" + sex +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
