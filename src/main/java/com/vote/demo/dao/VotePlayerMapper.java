package com.vote.demo.dao;


import com.vote.demo.model.VotePlayer;
import com.vote.demo.model.VotePlayerExample;

import java.util.List;
import java.util.Map;

public interface VotePlayerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VotePlayer record);

    int insertSelective(VotePlayer record);

    List<VotePlayer> selectByExample(VotePlayerExample example);

    VotePlayer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VotePlayer record);

    int updateByPrimaryKey(VotePlayer record);

    //获取所有选手信息
    List<Map> getAll();
}