package com.jinyuan.project.service;

import com.jinyuan.project.domain.TRequestMatch;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface TRequestMatchService {
    //显示所有的需求匹配结果
    List<Map<String, Object>> selectAllRequestMatchInfos(int pageNo,int pageSize);

    //用户查看自己的需求匹配信息
    List<TRequestMatch> selectMyRequests(@Param("_user")int _user);

    //查看需求详情
    TRequestMatch selectDetailRequestMatch(@Param("_id")int _id);

    //设置为已读状态
    int updateRequestIsRead(@Param("_id")int _id);

    //需求匹配结果显示
    //List<Map<String,Object>> selectAllRequestMatchInfo(Page page);

    //需求匹配结果总数
    //Integer selectTotalRequestMatchInfo(Page page);

    //根据request_id查看需求匹配结果详情
    List<Map<String, Object>> selectDetailRequestMatchBy_id(@Param("_id")int _id);

    //发送需求匹配结果信息给用户
    int sendToUser(int _user, String title, String message, int _thing);
}
