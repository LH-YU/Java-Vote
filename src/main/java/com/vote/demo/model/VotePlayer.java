package com.vote.demo.model;

import java.util.Date;

public class VotePlayer {
    private Integer id;

    private String playName;

    private String playImg;

    private Integer voteNum;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlayName() {
        return playName;
    }

    public void setPlayName(String playName) {
        this.playName = playName == null ? null : playName.trim();
    }

    public String getPlayImg() {
        return playImg;
    }

    public void setPlayImg(String playImg) {
        this.playImg = playImg == null ? null : playImg.trim();
    }

    public Integer getVoteNum() {
        return voteNum;
    }

    public void setVoteNum(Integer voteNum) {
        this.voteNum = voteNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}