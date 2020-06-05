package com.jinyuan.project.service;

import com.jinyuan.project.domain.TRequests;
import com.jinyuan.project.domain.TTrade;
import com.jinyuan.framework.web.Result;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface TRequestsService {
    //查找需求者信息 (基本信息加此人的所有需求信息)
    List<Map<String, Object>> selectRequestInfos(@Param("_id")int _id);

    //查找所有的需求信息
    List<Map<String, Object>> selectAllRequest();

    //根据_id查看需求详情
    Map<String, Object> selectRequestDetailById(@Param("_id")int _id);

    //编写二手商品需求信息
    int insertRequest(int owner, String thing_name,
                      float new_old, String memo,
                      float price_low, float price_high,
                      int exchangeable, Integer thing);

    //编写二手需求信息没有thing
    int insertRequestNoThing(TRequests tRequests);


    //查看我的需求信息
    List<Map<String, Object>> selectMyRequests(@Param("_owner")int _owner);

    //根据_id修改我的需求信息带thing
    Result updateMyRequestWithThing(@Param("thing_name")String thing_name, @Param("new_old")float new_old, @Param("memo")String memo,
                                    @Param("price_low")float price_low, @Param("price_high")float price_high, @Param("exchangeable")int exchangeable,
                                    @Param("_thing")Integer _thing, @Param("_id")int _id);

    //根据_id修改我的需求信息不带thing
    int updateMyRequestNoThing(@Param("thing_name")String thing_name, @Param("new_old")float new_old, @Param("memo")String memo,
                               @Param("price_low")float price_low, @Param("price_high")float price_high, @Param("exchangeable")int exchangeable,
                               @Param("_id")int _id);
    //需求交易
    Result RequestTransaction(String finished_date, int finished,
                              Float price, Integer _thing, int request_provider, int buyer_id_, int _id);

    // 需求交易不带thing
    int RequestTransactionNoThing(@Param("finished_date")String finished_date, @Param("finished")int finished,
                                  @Param("price")Float price, @Param("request_provider")int request_provider, @Param("_id")int _id);


    //插入交易记录
    int insertRequestTrade(TTrade ttrade);

    //插入交易信息不带thing
    int insertRequestTradeNoThing(TTrade ttrade);
}
