package com.jinyuan.mapper;

import com.jinyuan.domain.TRequests;
import com.jinyuan.domain.TTrade;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface TRequestsMapper {
    //被交换的物品改成交易状态
    int updateGetThingIsTradeState(@Param("finished_date")String finished_date,
                                    @Param("_buyer")int _buyer,@Param("_id")int _id);


    //查找需求者信息 (基本信息加此人的所有需求信息)
    List<Map<String,Object>> selectRequestInfos(@Param("_id")int _id);

    //查找所有的需求信息
    List<Map<String,Object>> selectAllRequest();

    //根据_id查看需求详情
    Map<String,Object> selectRequestDetailById(@Param("_id")int _id);

    //编写二手商品需求信息
    int insertRequest(TRequests tRequests);

    //编写二手需求信息没有thing
    int insertRequestNoThing(TRequests tRequests);

    //查看我的需求信息
    List<Map<String,Object>> selectMyRequests(@Param("_owner")int _owner);

    //根据_id修改我的需求信息带thing
    int updateMyRequestWithThing(@Param("thing_name")String thing_name,@Param("new_old")float new_old,@Param("memo")String memo,
                                  @Param("price_low")float price_low,@Param("price_high")float price_high,@Param("exchangeable")int exchangeable,
                                  @Param("_thing")int _thing,@Param("_id")int _id);

    //根据_id设置需求信息 中的_thing为NULL
    int update_thingById(@Param("_id")int _id);

    //根据_id修改我的需求信息不带thing
    int updateMyRequestNoThing(@Param("thing_name")String thing_name,@Param("new_old")float new_old,@Param("memo")String memo,
                                @Param("price_low")float price_low,@Param("price_high")float price_high,@Param("exchangeable")int exchangeable,
                                @Param("_id")int _id);

    //需求交易
    int RequestTransaction(@Param("finished_date")String finished_date,@Param("finished")int finished,
                            @Param("price")Float price,@Param("_thing2") Integer _thing2,@Param("request_provider")int request_provider,@Param("_id")int _id);

    // 需求交易不带thing
    int RequestTransactionNoThing(@Param("finished_date")String finished_date,@Param("finished")int finished,
                                   @Param("price")Float price,@Param("request_provider")int request_provider,@Param("_id")int _id);

    //插入交易记录
    int insertRequestTrade(TTrade ttrade);

    //插入交易信息不带thing
    int insertRequestTradeNoThing(TTrade ttrade);
}
