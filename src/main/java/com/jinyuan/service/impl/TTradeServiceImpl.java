package com.jinyuan.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jinyuan.mapper.TTradeMapper;
import com.jinyuan.service.TTradeServicee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Aaron
 * @description :
 * @Date 2020/5/28
 */
@Service
public class TTradeServiceImpl implements TTradeServicee {

    @Autowired
    TTradeMapper ttradeMapper;

    //查看我的交易记录
    @Override
    public JSONObject selectMyTrade(int user_id) {

        JSONObject jsonObject=new JSONObject();

            List<Map<String,Object>> mysells=ttradeMapper.selectSellInfos(user_id);

            List<Map<String,Object>> mysell_buys=ttradeMapper.selectSell_buyInfos(user_id);

            List<Map<String,Object>> myRequest_buys=ttradeMapper.selectRequest_buyInfos(user_id);

            List<Map<String,Object>> myRequest_sell=ttradeMapper.selectRequest_sellInfo(user_id);

            for(int i=0;i<myRequest_sell.size();i++) {
                mysells.add(myRequest_sell.get(i));
            }

            for(int i=0;i<myRequest_buys.size();i++) {
                mysell_buys.add(myRequest_buys.get(i));
            }

            /*if (mysells!=null&&mysell_buys!=null){
                jsonObject.put("success",0);
                jsonObject.put("sell",mysells);
                jsonObject.put("buy",mysell_buys);
                return jsonObject;
            }
            jsonObject.put("success",1);
            jsonObject.put("message","数据查询失败!");*/

            jsonObject.put("success",0);
            jsonObject.put("sell",mysells);
            jsonObject.put("buy",mysell_buys);
            return jsonObject;

    }

    //查看我的售卖商品售卖记录
    @Override
    public List<Map<String,Object>> selectSellInfos(int _owner) {

        return ttradeMapper.selectSellInfos(_owner);
    }

    //查看我的售卖商品购买记录
    @Override
    public List<Map<String,Object>> selectSell_buyInfos(int _buyer) {

        return ttradeMapper.selectSell_buyInfos(_buyer);
    }

    //查看我的需求商品购买记录
    @Override
    public List<Map<String,Object>> selectRequest_buyInfos(int _owner) {

        return ttradeMapper.selectRequest_buyInfos(_owner);
    }

    //查看我的需求商品售卖记录
    @Override
    public List<Map<String, Object>> selectRequest_sellInfo(int request_provider) {

        return ttradeMapper.selectRequest_sellInfo(request_provider);
    }

    //指定年份的每个月份售卖/需求商品发布数量统计
    @Override
    public JSONObject selectThingsAndRequestCountByMonth(int value1, int value2, int value3, int value4, int value5,
                                                         int value6, int value7, int value8, int value9, int value10, int value11, int value12) {

        JSONObject jsonObject=new JSONObject();
        Map<String,Object> request=ttradeMapper.selectRequestCountByMonth(value1, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11, value12);
        Map<String,Object> sell=ttradeMapper.selectThingsCountByMonth(value1, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11, value12);
        /*if (request!=null&&sell!=null){
            jsonObject.put("success",0);
            jsonObject.put("request",request);
            jsonObject.put("sell",sell);
            return jsonObject;
        }
        jsonObject.put("success",1);
        jsonObject.put("message","数据获取失败！");*/
        jsonObject.put("success",0);
        jsonObject.put("request",request);
        jsonObject.put("sell",sell);
        return jsonObject;
    }

    //指定年份的每隔月份交易情况
    @Override
    public JSONObject selectTradeSituationByMonth(int value1, int value2, int value3, int value4, int value5, int value6,
                                                  int value7, int value8, int value9, int value10, int value11, int value12) {

        Map<String,Object> requestNoDeal=ttradeMapper.RequestNoTradeByMonth(value1, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11, value12);
        Map<String,Object> requestDeal =ttradeMapper.RequestIsTradedByMonth(value1, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11, value12);
        Map<String,Object> sellNodeal =ttradeMapper.ThingNoTradeByMonth(value1, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11, value12);
        Map<String,Object> sellDeal =ttradeMapper.ThingIsTradedByMonth(value1, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11, value12);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("success",0);
        jsonObject.put("requestNoDeal",requestNoDeal);
        jsonObject.put("requestDeal",requestDeal);
        jsonObject.put("sellNodeal",sellNodeal);
        jsonObject.put("sellDeal",sellDeal);


        return jsonObject;
    }

}
