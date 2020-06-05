package com.jinyuan.project.service;


import com.alibaba.fastjson.JSONObject;
import com.jinyuan.project.domain.TUser;
import com.jinyuan.framework.web.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface TUserService {
    //查找每个月份注册用户数量
    JSONObject selectUserCountsByMonth(@Param("value1")int value1,
                                       @Param("value2")int value2, @Param("value3")int value3, @Param("value4")int value4,
                                       @Param("value5")int value5, @Param("value6")int value6, @Param("value7")int value7,
                                       @Param("value8")int value8, @Param("value9")int value9, @Param("value10")int value10,
                                       @Param("value11")int value11, @Param("value12")int value12);

    //查询不诚信用户决定分页查询还是条件查询
    List<TUser> selectUnhonestUserPageOrCondition(int pageNo,int pageSize);

    //查询注册用户决定分页查询还是条件查询
    List<TUser> findAllUsers(int pageNo,int pageSize);

    //不诚信交易详情信息
    Map<String, Object> selectUnhonestTradeDetail(int _id);


    //查看不诚信用户类型
    List<Map<String, Object>> selectDetailUnhonestUser(@Param("request_provider")int request_provider, @Param("_owner")int _owner);

    //条件查询不诚信用户
    //List<Map<String,Object>> selectUnhonestUserByCondition(Page page);

    //分页显示不诚信用户
    //List<Map<String,Object>> selectUnhonestUser(Page page);

    //所有不诚信用户信息
    //Integer selectTotalUnhonestUser(Page page);

    //根据条件显示用户信息
    //List<TUser> selectUserWithPageByCondition(Page page);

    //查找总用户数
    //Integer selectAllUserCounts(Page page);


    //分页显示用户信息
    //List<TUser> selectUserByPage(Page page);

    //重置密码
    int resetPassword(int _id);

    //启用用户
    Result startUser(int _id);

    //禁用用户
    Result forbiddenUser(int _id);

    //根据_id查找详情信息
    TUser selectUserDetailInfo(int _id);

    //根据账号或姓名查询用户
    List<TUser> selectUserByAccountAndName(@Param("name")String name, @Param("account")String account);

    //修改个人信息不带图片
    int updatePersonalInfoNoPhoto(@Param("name")String name, @Param("mobile")String mobile,
                                  @Param("weixin")String weixin, @Param("department")String department,
                                  @Param("_class")String _class, @Param("_id")int _id);

    //修改个人信息带图片
    Result updatePersonalInfoWithPhoto(String name, String mobile,
                                       String weixin, String department,
                                       String _class, MultipartFile photo, int _id, HttpServletRequest request);

    //登录
    TUser selectUserByAccountAndPassword(String account, String password);

    //查找所有用户
    List<TUser> selectAllUser();

    //注册
    Result insertUserWithPhoto(String account, String password, String name, String mobile, String weixin,
                               String department, String _class, MultipartFile photo, HttpServletRequest request);

    //判断用户是否已经存在
    TUser selectUserByAccount(@Param("account")String account);

    //查看我的交易
    List<Map<String,Object>> selectMyTrade();

    //查看个人信息
    Map<String, Object> selectPersonInformation(@Param("_user1")int _user1, @Param("_user2")int _user2, @Param("_id")int _id);
}
