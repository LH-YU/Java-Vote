package com.vote.demo.model;

import java.util.Date;

public class VoteUserPlayer {
    private Integer id;

    private String userName;

    private Integer palyerId;

    private Date createTime;

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
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getPalyerId() {
        return palyerId;
    }

    public void setPalyerId(Integer palyerId) {
        this.palyerId = palyerId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}