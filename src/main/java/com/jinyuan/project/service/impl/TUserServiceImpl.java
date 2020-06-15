package com.jinyuan.project.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.jinyuan.project.domain.TUser;
import com.jinyuan.framework.web.Result;
import com.jinyuan.project.mapper.TUserMapper;
import com.jinyuan.project.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Aaron
 * @description :
 * @Date 2020/5/26
 */
@Service
public class TUserServiceImpl implements TUserService {

    @Autowired
    TUserMapper tuserMapper;

    //登录
    @Override
    public TUser selectUserByAccountAndPassword(String account, String password) {

        TUser tuser=tuserMapper.selectUserByAccountAndPassword(account, password);
        return tuser;

    }

    //查找所有用户
    @Override
    public List<TUser> selectAllUser() {
        return tuserMapper.selectAllUser();
    }

    //注册
    @Override
    public Result insertUserWithPhoto(String account, String password, String name, String mobile, String weixin,
                                      String department, String _class, MultipartFile photo, HttpServletRequest request){

        TUser tuser=new TUser();
        tuser.setAccount(account);
        tuser.setPassword(password);
        tuser.setName(name);
        tuser.set_class(_class);
        tuser.setDepartment(department);
        tuser.setMobile(mobile);
        tuser.setWeixin(weixin);
        tuser.setState(1);
        tuser.setGrade(1);
        tuser.set_id((int)Math.round(Math.random()*100000000));
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        tuser.setRegister_date(sdf.format(date));
        String photoname="";

        if(tuserMapper.selectUserByAccount(account)!=null){
            //账号已经存在
            return Result.error("账号已存在");
        }

        try {

            if(photo!=null) {
                //photo.transferTo(new File(request.getSession().getServletContext().getRealPath("/images/"+photo.getOriginalFilename())));
                photoname=tuser.get_id()+"-"+photo.getOriginalFilename();
                String path="D:\\schoolTrade\\imagesUpload\\userIcon\\";
                File dir=new File(path);
                if (!dir.exists()){
                    dir.mkdir();
                }
                //保存文件
                File file=new File(dir,photoname);
                if (!file.exists()){
                    photo.transferTo(file);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        tuser.setPhoto(photoname);
        int  row=tuserMapper.insertUserWithPhoto(tuser);
        if (row>0){
            return Result.success("注册成功！",tuser.get_id());
        }
        return Result.error("注册失败！");
    }

    @Override
    public TUser selectUserByAccount(String account) {

        return tuserMapper.selectUserByAccount(account);
    }

    //查看我的交易
    @Override
    public List<Map<String, Object>> selectMyTrade() {

        return tuserMapper.selectMyTrade();
    }

    //查看个人信息
    @Override
    public Map<String, Object> selectPersonInformation(int _user1, int _user2, int _id) {

        Map<String,Object> map=tuserMapper.selectPersonInformation(_user1, _user2, _id);
        return map;

    }

    //修改个人信息不带图片
    @Override
    public int updatePersonalInfoNoPhoto(String name, String mobile, String weixin,
                                         String department, String _class, int _id) {

        return tuserMapper.updatePersonalInfoNoPhoto( name, mobile, weixin, department, _class, _id);
    }

    //修改个人信息带图片
    @Override
    public Result updatePersonalInfoWithPhoto(String name, String mobile,
                                              String weixin, String department,
                                              String _class, MultipartFile photo, int _id, HttpServletRequest request) {

        String photoname="";
        try {
            if(photo!=null){
                //图片不为空
                photoname=_id+"-"+photo.getOriginalFilename();
                String path="D:\\schoolTrade\\imagesUpload\\userIcon\\";
                File dir=new File(path);
                if (!dir.exists()){
                    dir.mkdir();
                }
                //保存文件
                File file=new File(dir,photoname);
                if (!file.exists()){
                    photo.transferTo(file);
                }
            }

            //photo.transferTo(new File(request.getSession().getServletContext().getRealPath("/images/"+photo.getOriginalFilename())));

        }catch(Exception e) {
            e.printStackTrace();
        }
        int row=tuserMapper.updatePersonalInfoWithPhoto( name, mobile, weixin, department, _class, photoname, _id);
        if (row>0){
            return Result.success("处理成功！",_id);
        }
        return Result.error("处理失败！");
    }

    //根据账号或姓名查询用户
    @Override
    public List<TUser> selectUserByAccountAndName(String name, String account) {

        return tuserMapper.selectUserByAccountAndName(name, account);
    }

    //根据_id查找用户详情信息
    @Override
    public TUser selectUserDetailInfo(int _id) {

        TUser tUser=tuserMapper.selectUserDetailInfo(_id);
        return tUser;
    }

    //禁用用户
    @Override
    public Result forbiddenUser(int _id) {

        if (tuserMapper.selectUserDetailInfo(_id).getState()==2){
            return Result.error("用户已经处于禁用状态,禁用失败");
        }
        int row=tuserMapper.forbiddenUser(_id);
        if (row>0){
            return Result.success("禁用成功！",_id);
        }
        return Result.error("禁用失败！");

    }

    //重置密码
    @Override
    public int resetPassword(int _id) {
        return tuserMapper.resetPassword(_id);
    }

    //启用用户
    @Override
    public Result startUser(int _id) {
        if (tuserMapper.selectUserDetailInfo(_id).getState()==1){
            return Result.error("用户已经处于启用状态");
        }
        int row=tuserMapper.startUser(_id);
        if (row>0){
            return Result.success("启用用户成功！",_id);
        }
        return Result.error("启用用户成功!");
    }

    @Override
    public Map<String, Object> selectUnhonestTradeDetail(int _id) {
        Map<String,Object> map=tuserMapper.selectUnhonestTradeDetail(_id);
        return map;
    }

    //查看不诚信用户类型
    @Override
    public List<Map<String, Object>> selectDetailUnhonestUser(int request_provider, int _owner) {
        List<Map<String,Object>> mapList=tuserMapper.selectDetailUnhonestUser(request_provider,_owner);

        return mapList;
    }

    //决定分页查询还是条件查询
    @Override
    @Cacheable(value = "findAllUsers",keyGenerator = "keyGenerator")
    public List<TUser> findAllUsers(int pageNo,int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<TUser> tUsers=null;

                //分页查询
                tUsers=tuserMapper.selectAllUsers();

                //条件查询
                //tUsers=tuserMapper.selectUsersByCondition(queryCondition);
        return tUsers;
    }

    //查询不诚信用户决定分页查询还是条件查询
    @Override
    @Cacheable(value = {"selectUnhonest"})
    public List<TUser> selectUnhonestUserPageOrCondition(int pageNo,int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<TUser>  tUsers=tuserMapper.selectUnhonestUsers();
        return  tUsers;
    }


    //查找每个月份注册用户数量
    @Override
    public JSONObject selectUserCountsByMonth(int year) {
        JSONObject jsonObject=new JSONObject();
        Map<String,Object> register=tuserMapper.selectUserCountsByMonth(year);
        jsonObject.put("success",0);
        jsonObject.put("register",register);

        return jsonObject;
    }

    @Override
    public Map<String, Object> selectAllUserGrade() {
        Map<String,Object> map=tuserMapper.selectAllUserGrade();
        return map;
    }
}
