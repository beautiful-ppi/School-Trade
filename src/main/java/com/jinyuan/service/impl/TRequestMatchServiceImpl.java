package com.jinyuan.service.impl;

import com.jinyuan.domain.TRequestMatch;
import com.jinyuan.mapper.TRequestMatchMapper;
import com.jinyuan.service.TRequestMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Aaron
 * @description :
 * @Date 2020/5/28
 */
@Service
public class TRequestMatchServiceImpl implements TRequestMatchService {

    @Autowired
    TRequestMatchMapper trequestMatchMapper;


    //查看自己的需求匹配信息
    @Override
    public List<TRequestMatch> selectMyRequests(int _user) {
        List<TRequestMatch> tRequestMatchList=trequestMatchMapper.selectMyRequests(_user);
        return tRequestMatchList;
    }

    //查看需求匹配详情
    @Override
    public TRequestMatch selectDetailRequestMatch(int _id) {
        trequestMatchMapper.updateRequestIsRead(_id);
        TRequestMatch tRequestMatch=trequestMatchMapper.selectDetailRequestMatch(_id);
        return tRequestMatch;
    }

    //设置已读状态
    @Override
    public int updateRequestIsRead(int _id) {
       return trequestMatchMapper.updateRequestIsRead(_id);
    }


    //根据request_id查看需求匹配结果详情
    @Override
    public List<Map<String, Object>> selectDetailRequestMatchBy_id(int _id) {

        List<Map<String,Object>> mapList=trequestMatchMapper.selectDetailRequestMatchBy_id(_id);
        return mapList;
    }

    //发送需求匹配结果信息
    @Override
    public int sendToUser(int _user, String title, String message, int _thing) {
        TRequestMatch tRequestMatch=new TRequestMatch();
        //tRequestMatch.set_id((int)Math.round(Math.random()*100000000));
        tRequestMatch.set_user(_user);
        tRequestMatch.setTitle(title);
        tRequestMatch.setMessage(message);
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        tRequestMatch.setMessage_date(sdf.format(date));
        tRequestMatch.set_thing(_thing);
        tRequestMatch.setIsRead(0);
        return trequestMatchMapper.sendToUser(tRequestMatch);
    }

    //需求匹配结果总数
	/*@Override
	public Integer selectTotalRequestMatchInfo(Page page) {
		// TODO Auto-generated method stub
		return trequestMatchMapper.selectTotalRequestMatchInfo(page);
	}*/

    //显示所有的需求匹配结果
    @Override
    public List<Map<String, Object>> selectAllRequestMatchInfos() {

        List<Map<String,Object>> mapList=trequestMatchMapper.selectAllRequestMatchInfos();
        return mapList;
    }
}
