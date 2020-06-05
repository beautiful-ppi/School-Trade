package com.jinyuan.project.controller;

import com.jinyuan.project.domain.TRequestMatch;
import com.jinyuan.framework.web.Result;
import com.jinyuan.project.service.impl.TRequestMatchServiceImpl;
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
public class TRequestMatchController {

    @Autowired
    TRequestMatchServiceImpl trequestMatchServiceImpl;


    //发送需求匹配结果信息
    @RequestMapping(value="sendToUser")
    public Result sendToUser(@RequestParam("_user")int _user, @RequestParam("title")String title,
                             @RequestParam("message")String message, @RequestParam("_thing")int _thing){
		int row=trequestMatchServiceImpl.sendToUser(_user, title, message, _thing);
        if (row>0){
            return Result.success("发送需求匹配结果信息成功！");
        }
        return Result.error("发送需求匹配结果信息失败！");
    }

    //根据request_id查看需求匹配结果详情
    @RequestMapping(value="selectDetailRequestMatchBy_id/{_id}")
    public Result selectDetailRequestMatchBy_id(@PathVariable("_id")int _id){
        List<Map<String,Object>> mapList=trequestMatchServiceImpl.selectDetailRequestMatchBy_id(_id);
        return Result.success("查看需求匹配结果详情",mapList);
    }

    //需求匹配结果显示
    @RequestMapping(value="selectAllRequestMatchInfo")
    public Result selectAllRequestMatchInfo(@RequestParam(value = "pageNo",required = false)int pageNo,@RequestParam(value = "pageSize",required = false)int pageSize) {
        List<Map<String,Object>> mapList=trequestMatchServiceImpl.selectAllRequestMatchInfos(pageNo,pageSize);
        return Result.success("显示需求匹配结果",mapList);
    }


    /**
     * 根据当前页获取开始行
     * @param currentPage
     * @param pageSize
     * @return
     */

    /*public int getStartRowBycurrentPage(int currentPage,int pageSize){

        int startRow=0;

        if (currentPage==1) {

            return startRow=0;
        }

        startRow=(currentPage-1)*pageSize;

        return startRow;

    }*/


    //查看需求匹配详情信息
    @RequestMapping(value="selectDetailRequestMatch/{_id}")
    public Result selectDetailRequestMatch(@PathVariable("_id")int _id){

        TRequestMatch tRequestMatch=trequestMatchServiceImpl.selectDetailRequestMatch(_id);
        return Result.success("查看需求匹配详情信息",tRequestMatch);
    }

    //查看自己的需求匹配信息
    @RequestMapping(value="selectMyRequestsBy_user/{_user}",produces="text/json;charset=UTF-8")
    public Result selectMyRequests(@PathVariable("_user")int _user){
        List<TRequestMatch> list= trequestMatchServiceImpl.selectMyRequests(_user);
        return Result.success("查看自己的需求匹配信息",list);
    }
}
