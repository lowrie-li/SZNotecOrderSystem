package com.SzNotec.OrderSystem.entity;

import java.util.Date;

public class User {

    private Integer usersno;

    private String uid;

    private Integer empsno;

    private String pwd;

    private String email;

    private String cmt;

    private Date updatetime;

    public Integer getUsersno() {
        return usersno;
    }

    public void setUsersno(Integer usersno) {
        this.usersno = usersno;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public Integer getEmpsno() {
        return empsno;
    }

    public void setEmpsno(Integer empsno) {
        this.empsno = empsno;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt == null ? null : cmt.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}