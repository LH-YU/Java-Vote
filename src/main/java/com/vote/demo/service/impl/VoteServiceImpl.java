package com.vote.demo.service.impl;

import com.vote.demo.dao.VotePlayerMapper;
import com.vote.demo.dao.VoteUserPlayerMapper;
import com.vote.demo.model.VotePlayer;
import com.vote.demo.model.VoteUserPlayer;
import com.vote.demo.model.VoteUserPlayerExample;
import com.vote.demo.service.VoteService;
import com.vote.demo.util.Result;
import com.vote.demo.vo.UserVoteVo;
import com.vote.demo.vo.VoteListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author LH-Yu
 * @date 2019-07-27
 */
@Service
@Transactional
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VotePlayerMapper votePlayerMapper;
    @Autowired
    private VoteUserPlayerMapper voteUserPlayerMapper;

    @Override
    public Result list(VoteListVo voteListVo) {
        //今天开始时间
        Calendar startTime = new GregorianCalendar();
        startTime.set(Calendar.HOUR_OF_DAY, 0);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.SECOND, 0);
        //今天结束时间
        Calendar endTime = new GregorianCalendar();
        endTime.set(Calendar.HOUR_OF_DAY, 23);
        endTime.set(Calendar.MINUTE, 59);
        endTime.set(Calendar.SECOND, 59);

        List<Map> votePlayers = votePlayerMapper.getAll();
        //遍历选手列表判断用户是否已经投过票
        for(Map map:votePlayers){
            //判断当前用户今天是否投过票
            VoteUserPlayerExample voteUserPlayerExample = new VoteUserPlayerExample();
            voteUserPlayerExample.createCriteria().andUserNameEqualTo(voteListVo.getUserName()).andPalyerIdEqualTo(Integer.valueOf(map.get("id").toString())).andCreateTimeBetween((Date)startTime.getTime().clone(),(Date)endTime.getTime().clone());
            List<VoteUserPlayer> voteUserPlayers = voteUserPlayerMapper.selectByExample(voteUserPlayerExample);
            if(voteUserPlayers.size()>0){
                //今天已经投过票
                map.put("isVote",true);
            }else{
                map.put("isVote",false);
            }
        }
        Result result = new Result();
        return result.success(votePlayers);
    }

    @Override
    public Result vote(UserVoteVo userVoteVo) {
        //今天开始时间
        Calendar startTime = new GregorianCalendar();
        startTime.set(Calendar.HOUR_OF_DAY, 0);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.SECOND, 0);
        //今天结束时间
        Calendar endTime = new GregorianCalendar();
        endTime.set(Calendar.HOUR_OF_DAY, 23);
        endTime.set(Calendar.MINUTE, 59);
        endTime.set(Calendar.SECOND, 59);
        //判断当前用户今天是否投过票
        VoteUserPlayerExample voteUserPlayerExample = new VoteUserPlayerExample();
        voteUserPlayerExample.createCriteria().andUserNameEqualTo(userVoteVo.getUserName()).andCreateTimeBetween((Date)startTime.getTime().clone(),(Date)endTime.getTime().clone());
        List<VoteUserPlayer> voteUserPlayers = voteUserPlayerMapper.selectByExample(voteUserPlayerExample);
        if(voteUserPlayers.size()>0){
            //今天已经投过票
            return Result.fail("重复投票", Result.CodeEnum.重复投票);
        }
        //记录投票信息
        VoteUserPlayer voteUserPlayer = new VoteUserPlayer();
        voteUserPlayer.setUserName(userVoteVo.getUserName());
        voteUserPlayer.setPalyerId(userVoteVo.getPlayerId());
        voteUserPlayerMapper.insertSelective(voteUserPlayer);
        //修改投票数量
        VotePlayer votePlayer = votePlayerMapper.selectByPrimaryKey(userVoteVo.getPlayerId());
        votePlayer.setVoteNum(votePlayer.getVoteNum()+1);
        votePlayerMapper.updateByPrimaryKeySelective(votePlayer);
        Result result = new Result();
        return result.success(true);
    }

//    public static void main(String[] args) {
//        Calendar currentDate = new GregorianCalendar();
//        currentDate.set(Calendar.HOUR_OF_DAY, 0);
//        currentDate.set(Calendar.MINUTE, 0);
//        currentDate.set(Calendar.SECOND, 0);
//
//        currentDate.set(Calendar.HOUR_OF_DAY, 23);
//        currentDate.set(Calendar.MINUTE, 59);
//        currentDate.set(Calendar.SECOND, 59);
//        System.out.println((Date) currentDate.getTime().clone() + " --- " + (Date)currentDate.getTime().clone());
//    }

}
