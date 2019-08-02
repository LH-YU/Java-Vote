package com.vote.demo.dao;

import com.vote.demo.model.VoteUserPlayer;
import com.vote.demo.model.VoteUserPlayerExample;

import java.util.List;

public interface VoteUserPlayerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VoteUserPlayer record);

    int insertSelective(VoteUserPlayer record);

    List<VoteUserPlayer> selectByExample(VoteUserPlayerExample example);

    VoteUserPlayer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VoteUserPlayer record);

    int updateByPrimaryKey(VoteUserPlayer record);
}