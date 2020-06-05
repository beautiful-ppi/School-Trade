package com.jinyuan.project.controller;

import com.jinyuan.framework.web.Result;
import com.jinyuan.project.service.impl.TRequestsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Aaron
 * @description :
 * @Date 2020/5/28
 */

@RestController
@CrossOrigin
public class TRequestsController {
    @Autowired
    TRequestsServiceImpl trequestsServiceImpl;

    //查找需求者信息 (基本信息加此人的所有需求信息)
    @RequestMapping(value="selectRequestInfos/{_id}")
    public Result selectRequestInfos(@PathVariable("_id")int _id) {
        List<Map<String, Object>> mapList= trequestsServiceImpl.selectRequestInfos(_id);
        return Result.success("查找需求者信息",mapList);
    }

    //需求交易
    @RequestMapping(value="RequestTransaction/{_id}")
    public Result RequestTransaction(@PathVariable("_id")int _id, @RequestParam("finished_date")String finished_date,
                                     @RequestParam("finished")int finished, @RequestParam(required=false,value="price")Float price,
                                     @RequestParam(required=false,value="getThing")Integer getThing, @RequestParam("request_provider")int request_provider,
                                     @RequestParam("buyer_id")int buyer_id) {

        return trequestsServiceImpl.RequestTransaction(finished_date, finished, price, getThing, request_provider,buyer_id,_id);
    }

    //根据_id修改我的需求信息
    @RequestMapping(value="updateMyRequest/{_id}")
    public Result updateMyRequest(@PathVariable("_id")int _id,@RequestParam("thing_name")String thing_name,@RequestParam("new_old")float new_old,
                                  @RequestParam("memo")String memo,@RequestParam("price_low")float price_low,@RequestParam("price_high")float price_high,
                                  @RequestParam("exchangeable")int exchangeable,@RequestParam(required=false,value="thing")Integer thing){
        return trequestsServiceImpl.updateMyRequestWithThing(thing_name, new_old, memo, price_low, price_high, exchangeable, thing, _id);
    }

    //查看我的需求信息
    @RequestMapping(value="selectMyRequests/{_owner}")
    public Result selectMyRequests(@PathVariable("_owner")int _owner){
        List<Map<String, Object>> mapList= trequestsServiceImpl.selectMyRequests(_owner);
        return Result.success("查看我的需求信息",mapList);
    }

    //增加需求信息
    @RequestMapping(value="insertRequest")
    public Result insertRequest(@RequestParam("owner")int owner,@RequestParam("thing_name")String thing_name,
                                @RequestParam("new_old")float new_old,@RequestParam("memo")String memo,
                                @RequestParam("price_low")float price_low,@RequestParam("price_high")float price_high,
                                @RequestParam("exchangeable")int exchangeable,@RequestParam(required=false,value="thing")Integer thing){

        int row=trequestsServiceImpl.insertRequest(owner, thing_name, new_old, memo, price_low, price_high, exchangeable, thing);
        if (row>0){
            return Result.success("添加需求信息成功！");
        }
        return Result.error("添加需求信息失败！");
    }

    //查看需求详情信息
    @RequestMapping(value="selectRequestDetailById/{_id}")
    public Result selectRequestDetailById(@PathVariable("_id")int _id){
        Map<String, Object> map= trequestsServiceImpl.selectRequestDetailById(_id);
        return Result.success("查看需求详情信息成功！",map);

    }

    //查看所有需求
    @RequestMapping(value="selectAllRequest")
    public Result selectAllRequest(){
        List<Map<String, Object>> mapList =trequestsServiceImpl.selectAllRequest();
        return Result.success("查看所有需求成功！",mapList);
    }
}
