package com.jinyuan.controller;

import com.google.gson.Gson;
import com.jinyuan.domain.TThings;
import com.jinyuan.framework.web.Result;
import com.jinyuan.service.impl.TThingsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Aaron
 * @description :
 * @Date 2020/5/28
 */
@RestController
@CrossOrigin
public class TThingsController {
    @Autowired
    TThingsServiceImpl tthingsServiceImpl;


    //查找售卖人信息 (基本信息加此人的所有售卖信息)
    @RequestMapping(value="selectSellerInfos/{_id}")
    public Result selectSellerInfos(@PathVariable("_id")int _id){
        List<Map<String,Object>> mapList= tthingsServiceImpl.selectSellerInfos(_id);
        return Result.success("查找售卖人信息",mapList);
    }

    //售卖交易
    @RequestMapping(value="TthingsTransaction/{_id}")
    public Result TthingsTransaction(@PathVariable("_id")int _id,@RequestParam("finished_date")String finished_date,
                                     @RequestParam("finished")int finished,
                                     @RequestParam("buyer_id")int buyer_id,@RequestParam("seller_id")int seller_id,
                                     @RequestParam(required=false,value="price")Float price,@RequestParam(required=false,value="getThing")Integer getThing) {

        return tthingsServiceImpl.TthingsTransaction(finished_date, finished, getThing, buyer_id,seller_id, _id);
    }

    //根据_id获取商品售卖详细信息不能显示商品图片
    @RequestMapping(value="selectTthingsDetailByIdNoPhoto/{_id}")
    public Result selectTthingsDetailByIdNoPhoto(@PathVariable("_id")int _id){
        TThings tthing=tthingsServiceImpl.selectTthingsDetailByIdNoPhoto(_id);
        return Result.success("获取商品售卖详细信息",tthing);
    }

    //根据_id更新商品信息
    @RequestMapping(value="updateMyTthings/{_id}",produces="text/json;charset=UTF-8")
    public Result updateMyTthings(@PathVariable("_id")int _id,@RequestParam("thing_name")String thing_name,@RequestParam("new_old")float new_old,
                                  @RequestParam("memo")String memo,@RequestParam("price")float price,
                                  @RequestParam("exchangeable")int exchangeable,@RequestParam(required=false,value="photo1")MultipartFile[] photo1,HttpServletRequest request){
        return tthingsServiceImpl.updateMyTthingsNoThings(thing_name, new_old, memo, price, exchangeable, _id,photo1,request);
    }

    //查看我的二手售卖信息
    @RequestMapping(value="selectMyTthings/{_owner}",produces="text/json;charset=UTF-8")
    public Result selectMyTthings(@PathVariable("_owner")int _owner){
        List<Map<String,Object>> mapList= tthingsServiceImpl.selectMyTthings(_owner);
        return Result.success("查看我的二手售卖信息",mapList);
    }

    //添加二手售卖信息
    @RequestMapping(value="insertTthings",produces="text/json;charset=UTF-8")
    public Result insertTthings(@RequestParam("owner")int owner,@RequestParam("thing_name")String thing_name,
                                @RequestParam("new_old")float new_old,@RequestParam("memo")String memo,
                                @RequestParam("price")float price,@RequestParam("exchangeable")int exchangeable,
                                @RequestParam(required=false,value="photo1") MultipartFile[] photo1,
                                HttpServletRequest request) throws IOException {


        return tthingsServiceImpl.insertTthings(owner, thing_name, new_old, memo, price, exchangeable, photo1,request);
    }

    //根据_id查找二手货售卖详细信息
    @RequestMapping(value="selectTthingsDetailById/{_id}",produces="text/json;charset=UTF-8")
    public Result selectTthingsDetailById(@PathVariable("_id")int _id){
        Map<String, Object> map= tthingsServiceImpl.selectTthingsDetailById(_id);
        return Result.success("根据_id查找二手货售卖详细信息",map);
    }

    //查找所有二手商品售卖信息
    @RequestMapping(value="selectAllTthings",produces="text/json;charset=UTF-8")
    public Result selectAllTthings(){
        List<Map<String, Object>> mapList= tthingsServiceImpl.selectAllTthings();
        return Result.success("查找所有二手商品售卖信息",mapList);
    }
}
