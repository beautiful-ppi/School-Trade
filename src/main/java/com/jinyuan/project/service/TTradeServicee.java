package com.jinyuan.project.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface TTradeServicee {
    //指定年份的每隔月份交易情况
    JSONObject selectTradeSituationByMonth(int value1, int value2, int value3, int value4, int value5, int value6,
                                           int value7, int value8, int value9, int value10, int value11, int value12);

    //指定年份的每个月份售卖/需求商品发布数量统计
    JSONObject selectThingsAndRequestCountByMonth(int value1,
                                                  int value2, int value3, int value4,
                                                  int value5, int value6, int value7,
                                                  int value8, int value9, int value10,
                                                  int value11, int value12);



    //查看我的交易记录
    JSONObject selectMyTrade(int user_id);

    //查看我的售卖商品售卖记录
    List<Map<String,Object>> selectSellInfos(@Param("_owner")int _owner);

    //查看我的需求商品售卖记录
    List<Map<String,Object>> selectRequest_sellInfo(@Param("request_provider")int request_provider);

    //查看我的售卖商品购买记录
    List<Map<String,Object>> selectSell_buyInfos(@Param("_buyer")int _buyer);

    //查看我的需求商品购买记录
    List<Map<String,Object>> selectRequest_buyInfos(@Param("_owner")int _owner);

}
