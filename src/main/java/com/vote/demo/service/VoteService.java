package com.vote.demo.service;

import com.vote.demo.util.Result;
import com.vote.demo.vo.UserVoteVo;
import com.vote.demo.vo.VoteListVo;

public interface VoteService {

    Result list(VoteListVo voteListVo);

    Result vote(UserVoteVo userVoteVo);
}