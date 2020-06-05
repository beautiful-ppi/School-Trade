package com.jinyuan.project.service.impl;

import com.jinyuan.project.domain.TRequests;
import com.jinyuan.project.domain.TTrade;
import com.jinyuan.framework.web.Result;
import com.jinyuan.project.mapper.TRequestsMapper;
import com.jinyuan.project.service.TRequestsService;
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
public class TRequestsServiceImpl implements TRequestsService {

    @Autowired
    TRequestsMapper trequestsMapper;

    //查看所有需求信息
    @Override
    public List<Map<String, Object>> selectAllRequest() {

        List<Map<String,Object>> mapList=trequestsMapper.selectAllRequest();

        return mapList;
    }

    //根据_id查看需求详情
    @Override
    public Map<String, Object> selectRequestDetailById(int _id) {
        Map<String,Object> map=trequestsMapper.selectRequestDetailById(_id);
        return map;

    }

    //编写二手商品需求信息
    @Override
    public int insertRequest(int owner, String thing_name,
                             float new_old, String memo,
                             float price_low, float price_high,
                             int exchangeable, Integer thing) {
        TRequests trequests=new TRequests();
        trequests.set_owner(owner);
        trequests.setThing_name(thing_name);
        trequests.setNew_old(new_old);
        trequests.setMemo(memo);
        trequests.setPrice_low(price_low);
        trequests.setPrice_high(price_high);
        trequests.setExchangeable(exchangeable);
        trequests.set_id((int)Math.round(Math.random()*100000000));
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        trequests.setPublish_date(sdf.format(date));
        trequests.setFinished(0);

        trequests.set_thing(thing);

        return trequestsMapper.insertRequest(trequests);

    }

    //查看我的需求信息
    @Override
    public List<Map<String, Object>> selectMyRequests(int _owner) {
        List<Map<String,Object>> mapList=trequestsMapper.selectMyRequests(_owner);

        return mapList;
    }

    //需求交易
    @Override
    public Result RequestTransaction(String finished_date, int finished, Float price, Integer _thing, int request_provider,
                                     int buyer_id, int _id) {

            if(_thing==null) {
                //金钱交易
                int row=trequestsMapper.RequestTransactionNoThing(finished_date, finished, price, request_provider, _id);
                if (row>0){
                    return Result.success("交易成功！");
                }
                return Result.error("交易失败");
            }else{
                //物物交换
                int row1=trequestsMapper.RequestTransaction(finished_date, finished, (float) 0,_thing,request_provider, _id);
                int row2=trequestsMapper.updateGetThingIsTradeState(finished_date,request_provider,_thing);
                if (row1>0&&row2>0){
                    return Result.success("交易成功！");
                }
                return Result.success("交易失败！");
            }

    }

    //查找需求者信息 (基本信息加此人的所有需求信息)
    @Override
    public List<Map<String, Object>> selectRequestInfos(int _id) {
        List<Map<String,Object>> mapList= trequestsMapper.selectRequestInfos(_id);
        return mapList;
    }

    //插入交易记录
    @Override
    public int insertRequestTrade(TTrade ttrade) {
        // TODO Auto-generated method stub
        return trequestsMapper.insertRequestTrade(ttrade);
    }

    //编写二手需求信息没有thing
    @Override
    public int insertRequestNoThing(TRequests tRequests) {
        // TODO Auto-generated method stub
        return trequestsMapper.insertRequestNoThing(tRequests);
    }

    @Override
    public int RequestTransactionNoThing(String finished_date, int finished, Float price, int request_provider,
                                         int _id) {
        // TODO Auto-generated method stub
        return trequestsMapper.RequestTransactionNoThing(finished_date, finished, price, request_provider, _id);
    }

    @Override
    public int insertRequestTradeNoThing(TTrade ttrade) {
        // TODO Auto-generated method stub
        return trequestsMapper.insertRequestTradeNoThing(ttrade);
    }

    @Override
    public int updateMyRequestNoThing(String thing_name, float new_old, String memo, float price_low, float price_high,
                                      int exchangeable, int _id) {
        // TODO Auto-generated method stub
        return trequestsMapper.updateMyRequestNoThing(thing_name, new_old, memo, price_low, price_high, exchangeable, _id);
    }

    @Override
    public Result updateMyRequestWithThing(String thing_name, float new_old, String memo, float price_low,
                                           float price_high, int exchangeable, Integer _thing, int _id) {

            if(_thing==null){
                int row1=trequestsMapper.updateMyRequestNoThing(thing_name, new_old, memo, price_low, price_high, exchangeable, _id);
                int row2=trequestsMapper.update_thingById(_id);
                if (row1>0&&row2>2){
                    return Result.success("更新成功！");
                }
                return Result.error("更新失败！");
            }else {
                int row=trequestsMapper.updateMyRequestWithThing(thing_name, new_old, memo, price_low, price_high, exchangeable, _thing, _id);
                if (row>0){
                    return Result.success("更新成功！");
                }
                return Result.error("更新失败！");
            }


    }

}
