package com.jinyuan.project.controller;

import com.alibaba.fastjson.JSONObject;

import com.jinyuan.framework.annotation.ManagerLoginToken;
import com.jinyuan.project.domain.TUser;
import com.jinyuan.framework.token.TokenService;
import com.jinyuan.framework.web.Result;
import com.jinyuan.project.service.impl.TUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * @Date 2020/5/26
 */
@RestController
@CrossOrigin
public class TUserController {

    @Autowired
    TUserServiceImpl tuserServiceImpl;
    @Autowired
    TokenService tokenService;
    private static final Logger log= LoggerFactory.getLogger(TUserController.class);

    //查找每个月份注册用户数量
    @RequestMapping(value="selectUserCountsByMonth")
    public JSONObject selectUserCountsByMonth(@RequestParam("year")int year){
        return tuserServiceImpl.selectUserCountsByMonth(year);
    }

    //不诚信交易详情信息
    @RequestMapping(value="selectUnhonestTradeDetail/{_id}")
    @ManagerLoginToken
    public Result selectUnhonestTradeDetail(@PathVariable("_id")int _id,HttpServletRequest request) {
        log.info("token"+request.getHeader("token"));

        Map<String,Object> map= tuserServiceImpl.selectUnhonestTradeDetail(_id);
        return Result.success("不诚信交易详情信息",map);
    }

    //查看不诚信用户类型
    @RequestMapping(value="selectDetailUnhonestUser/{_id}")
    public Result selectDetailUnhonestUser(@PathVariable("_id")int _id){

        List<Map<String,Object>> mapList= tuserServiceImpl.selectDetailUnhonestUser(_id, _id);
        return Result.success("查看不诚信用户类型",mapList);
    }


    //分页显示不诚信用户
    @RequestMapping(value="selectUnhonestUser")
    @ManagerLoginToken //测试管理员登录
    public Result selectUnhonestUser(@RequestParam(required=false,value="pageNo")int pageNo,@RequestParam(required=false,value="pageSize")int pageSize) {



        List<TUser> tUserList=tuserServiceImpl.selectUnhonestUserPageOrCondition(pageNo,pageSize);

        return Result.success("显示不诚信用户",tUserList);
    }


    //根据分页显示用户信息
    @RequestMapping(value="selectUserByPage")
    public Result selectUserByPage(@RequestParam(required=false,value="pageNo")int pageNo,@RequestParam(required=false,value="pageSize")int pageSize) {

        List<TUser> list= tuserServiceImpl.findAllUsers(pageNo,pageSize);
        return Result.success("根据分页显示用户信息",list);
    }



    //重置密码
    @RequestMapping(value="resetPassword/{_id}")
    public Result resetPassword(@PathVariable("_id")int _id) {
        int row= tuserServiceImpl.resetPassword(_id);
        if (row>0){
            return Result.success("重置密码成功！");
        }
        return Result.error("重置密码失败！");
    }

    //启用用户
    @RequestMapping(value="startUser/{_id}")
    public Result startUser(@PathVariable("_id")int _id) {
        return tuserServiceImpl.startUser(_id);
    }

    //禁用用户
    @RequestMapping(value="forbiddenUser/{_id}")
    public Result forbiddenUser(@PathVariable("_id")int _id) {

        return tuserServiceImpl.forbiddenUser(_id);
    }

    //根据_id查找用户详情信息
    @RequestMapping(value="selectUserDetailInfo/{_id}")
    public Result selectUserDetailInfo(@PathVariable("_id")int _id){
        TUser tUser= tuserServiceImpl.selectUserDetailInfo(_id);
        return Result.success("根据_id查找用户详情信息",tUser);
    }


    //根据账号或姓名查询用户
    @RequestMapping(value="selectUserByAccountAndName")
    public Result selectUserByAccountAndName(@RequestParam(required=false,value="name")String name,
                                             @RequestParam(required=false,value="account")String account){

        List<TUser> list= tuserServiceImpl.selectUserByAccountAndName(name, account);

        return Result.success("根据账号或姓名查询用户",list);
    }


    //修改个人信息
    @RequestMapping(value="updatePersonalInfo")
    public Result updatePersonalInfo(@RequestParam(required=false,value="photo") MultipartFile photo, @RequestParam("name")String name,
                                     @RequestParam("mobile")String mobile, @RequestParam("weixin")String weixin,
                                     @RequestParam("department")String department, @RequestParam("classroom")String classroom,
                                     @RequestParam("id")int id, HttpServletRequest request) throws IOException {

        return tuserServiceImpl.updatePersonalInfoWithPhoto(name, mobile, weixin, department, classroom, photo,id,request);
    }

    //查看个人信息
    @RequestMapping(value="selectPersonInformation/{_id}")
    public Result selectPersonInformation(@PathVariable("_id")int _id) {
        Map<String,Object> map= tuserServiceImpl.selectPersonInformation(_id, _id, _id);
        return Result.success("查看个人信息",map);
    }



    //注册
    @RequestMapping(value="insertUserWithPhoto")
    public Result insertUserWithPhoto(@RequestParam("account")String account,@RequestParam("password")String password,
                                      @RequestParam("name")String name,@RequestParam("mobile")String mobile,@RequestParam("weixin")String weixin,
                                      @RequestParam("department")String department,@RequestParam("classroom")String classroom,
                                      @RequestParam(required=false,value="photo")MultipartFile photo,HttpServletRequest request) throws IOException{
        return tuserServiceImpl.insertUserWithPhoto(account, password, name, mobile, weixin, department, classroom, photo,request);
    }


    //查找所有用户
    @RequestMapping(value="selectAllUser")
    public Result selectAllUser() {

        List<TUser> list=tuserServiceImpl.selectAllUser();
        return Result.success("查找所有用户",list);
    }

    //用户登录
    @RequestMapping(value="selectUserByAccountAndPassword")
    public JSONObject selectUserByAccountAndPassword(@RequestParam("account")String account,@RequestParam("password")String password) {

        JSONObject jsonObject=new JSONObject();
        TUser tuser=tuserServiceImpl.selectUserByAccountAndPassword(account, password);
        if (tuser==null){
            jsonObject.put("success",1);
            jsonObject.put("message","账号或密码错误,请重新输入！");
            return jsonObject;
        }
        if (tuser.getState()!=1){
            jsonObject.put("success",1);
            jsonObject.put("message","由于不诚信行为,此账号已被禁用!");
            return jsonObject;
        }
        String uToken=tokenService.getTokenUser(tuser);
        jsonObject.put("success",0);
        jsonObject.put("utoken",uToken);
        jsonObject.put("username",tuser.getAccount());
        return jsonObject;


    }

    //查询所有用户等级
    @RequestMapping(value = "selectAllUserGrade")
    public Result selectAllUserGrade(){
        Map<String,Object> map=tuserServiceImpl.selectAllUserGrade();
        return Result.success("所有用户等级",map);
    }

}
