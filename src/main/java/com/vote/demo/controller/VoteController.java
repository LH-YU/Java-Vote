package com.vote.demo.controller;

import com.vote.demo.service.VoteService;
import com.vote.demo.util.Result;
import com.vote.demo.vo.UserVoteVo;
import com.vote.demo.vo.VoteListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    private VoteService voteService;

    /**
     * 获取所有参与投票选手的信息
     * @return
     */
    @PostMapping("/list")
    public Result list(@RequestBody VoteListVo voteListVo) {
        return voteService.list(voteListVo);
    }

    /**
     * 用户给选手投票
     * @param userVoteVo
     * @return
     */
    @PostMapping("/vote")
    public Result vote(@RequestBody UserVoteVo userVoteVo) {
        return voteService.vote(userVoteVo);
    }

}
