package com.jinyuan.mapper;

import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface TTradeMapper {

    //每个月售卖商品已交易
    Map<String,Object> ThingIsTradedByMonth(@Param("value1")int value1,
                                            @Param("value2")int value2, @Param("value3")int value3, @Param("value4")int value4,
                                            @Param("value5")int value5, @Param("value6")int value6, @Param("value7")int value7,
                                            @Param("value8")int value8, @Param("value9")int value9, @Param("value10")int value10,
                                            @Param("value11")int value11, @Param("value12")int value12);

    //每个月需求商品已交易
    Map<String,Object> RequestIsTradedByMonth(@Param("value1")int value1,
                                              @Param("value2")int value2,@Param("value3")int value3,@Param("value4")int value4,
                                              @Param("value5")int value5,@Param("value6")int value6,@Param("value7")int value7,
                                              @Param("value8")int value8,@Param("value9")int value9,@Param("value10")int value10,
                                              @Param("value11")int value11,@Param("value12")int value12);

    //每个月需求商品未交易
    Map<String,Object> RequestNoTradeByMonth(@Param("value1")int value1,
                                             @Param("value2")int value2,@Param("value3")int value3,@Param("value4")int value4,
                                             @Param("value5")int value5,@Param("value6")int value6,@Param("value7")int value7,
                                             @Param("value8")int value8,@Param("value9")int value9,@Param("value10")int value10,
                                             @Param("value11")int value11,@Param("value12")int value12);

    // 每个月售卖商品未交易
    Map<String,Object> ThingNoTradeByMonth(@Param("value1")int value1,
                                           @Param("value2")int value2,@Param("value3")int value3,@Param("value4")int value4,
                                           @Param("value5")int value5,@Param("value6")int value6,@Param("value7")int value7,
                                           @Param("value8")int value8,@Param("value9")int value9,@Param("value10")int value10,
                                           @Param("value11")int value11,@Param("value12")int value12);

    //指定年份的每个月份售卖商品发布数量统计
    Map<String,Object> selectThingsCountByMonth(@Param("value1")int value1,
                                                @Param("value2")int value2,@Param("value3")int value3,@Param("value4")int value4,
                                                @Param("value5")int value5,@Param("value6")int value6,@Param("value7")int value7,
                                                @Param("value8")int value8,@Param("value9")int value9,@Param("value10")int value10,
                                                @Param("value11")int value11,@Param("value12")int value12);

    //指定年份的每个月份需求商品发布数量统计
    Map<String,Object> selectRequestCountByMonth(@Param("value1")int value1,
                                                 @Param("value2")int value2,@Param("value3")int value3,@Param("value4")int value4,
                                                 @Param("value5")int value5,@Param("value6")int value6,@Param("value7")int value7,
                                                 @Param("value8")int value8,@Param("value9")int value9,@Param("value10")int value10,
                                                 @Param("value11")int value11,@Param("value12")int value12);

    //查看我的交易记录
    List<Map<String,Object>> selectMyTrade(@Param("seller_id")int seller_id, @Param("buyer_id")int buyer_id);

    //查看我的售卖商品售卖记录
    List<Map<String,Object>> selectSellInfos(@Param("_owner")int _owner);

    //查看我的需求商品售卖记录
    List<Map<String,Object>> selectRequest_sellInfo(@Param("request_provider")int request_provider);

    //查看我的售卖商品购买记录
    List<Map<String,Object>> selectSell_buyInfos(@Param("_buyer")int _buyer);

    //查看我的需求商品购买记录
    List<Map<String,Object>> selectRequest_buyInfos(@Param("_owner")int _owner);
}
