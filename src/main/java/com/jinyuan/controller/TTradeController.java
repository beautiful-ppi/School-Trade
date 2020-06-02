package com.jinyuan.controller;

import com.alibaba.fastjson.JSONObject;
import com.jinyuan.service.impl.TTradeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Aaron
 * @description :
 * @Date 2020/5/28
 */
@RestController
@CrossOrigin
public class TTradeController {
    @Autowired
    TTradeServiceImpl ttradeServiceImpl;


    //指定年份的每个月份交易情况
    @RequestMapping(value="selectTradeSituationByMonth")
    public JSONObject selectTradeSituationByMonth(@RequestParam("year")int year) {
        return ttradeServiceImpl.selectTradeSituationByMonth(year, year, year, year, year, year, year, year, year, year, year, year);
    }

    //指定年份的每个月份售卖/需求商品发布数量统计
    @RequestMapping(value="selectThingsAndRequestCountByMonth")
    public JSONObject selectThingsAndRequestCountByMonth(@RequestParam("year")int year){
        return ttradeServiceImpl.selectThingsAndRequestCountByMonth(year, year, year, year, year, year, year, year, year, year, year, year);
    }

    //查看我的交易记录
    @RequestMapping(value="selectMyTrade/{user_id}")
    public JSONObject selectMyTrade(@PathVariable("user_id")int user_id){

        return ttradeServiceImpl.selectMyTrade(user_id);
    }
}
