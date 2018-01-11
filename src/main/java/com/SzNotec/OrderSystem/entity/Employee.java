package com.SzNotec.OrderSystem.entity;

import java.util.Date;

public class Employee {
    private Integer empsno;

    private Integer groupsno;

    private Integer jobsno;

    private Integer contactsno;

    private String idno;

    private Integer basicsalary;

    private Date onboarddate;

    private Integer accountsno;

    private Date updatetime;

    private String cmt;

    public Integer getEmpsno() {
        return empsno;
    }

    public void setEmpsno(Integer empsno) {
        this.empsno = empsno;
    }

    public Integer getGroupsno() {
        return groupsno;
    }

    public void setGroupsno(Integer groupsno) {
        this.groupsno = groupsno;
    }

    public Integer getJobsno() {
        return jobsno;
    }

    public void setJobsno(Integer jobsno) {
        this.jobsno = jobsno;
    }

    public Integer getContactsno() {
        return contactsno;
    }

    public void setContactsno(Integer contactsno) {
        this.contactsno = contactsno;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno == null ? null : idno.trim();
    }

    public Integer getBasicsalary() {
        return basicsalary;
    }

    public void setBasicsalary(Integer basicsalary) {
        this.basicsalary = basicsalary;
    }

    public Date getOnboarddate() {
        return onboarddate;
    }

    public void setOnboarddate(Date onboarddate) {
        this.onboarddate = onboarddate;
    }

    public Integer getAccountsno() {
        return accountsno;
    }

    public void setAccountsno(Integer accountsno) {
        this.accountsno = accountsno;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt == null ? null : cmt.trim();
    }
}