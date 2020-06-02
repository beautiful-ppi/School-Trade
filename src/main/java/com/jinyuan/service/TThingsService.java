package com.jinyuan.service;

import com.jinyuan.domain.TThings;
import com.jinyuan.domain.TTrade;
import com.jinyuan.domain.TUser;
import com.jinyuan.framework.web.Result;
import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface TThingsService {
    //查找售卖人信息 (基本信息加此人的所有售卖信息)
    List<Map<String, Object>> selectSellerInfos(@Param("_id")int _id);

    //查看所有二手货售卖信息
    List<Map<String, Object>> selectAllTthings();

    //查看二手货售卖详情信息
    Map<String, Object> selectTthingsDetailById(@Param("_id")int _id);

    //添加二手售卖信息
    Result insertTthings(int _owner, String thing_name, float new_old,
                         String memo, float price, int exchangeable, MultipartFile[] photo1, HttpServletRequest request);

    //添加二手货售卖信息的同时添加图片
    //void insertMultiplePhoto(TThingsPhoto tThingsPhoto);

    //查看我的二手售卖信息
    List<Map<String, Object>> selectMyTthings(@Param("_owner")int _owner);


    //根据商品_id修改商品信息现金交易
    Result updateMyTthingsNoThings(@Param("thing_name")String thing_name, @Param("new_old")float new_old, @Param("memo")String memo,
                                   @Param("price")float price, @Param("exchangeable")int exchangeable, @Param("_id")int _id, MultipartFile[] photo1,
                                   HttpServletRequest request);

    //根据商品_id修改商品信息物物交易
    int updateMyTthingsWithThings(@Param("thing_name")String thing_name, @Param("new_old")float new_old, @Param("memo")String memo,
                                  @Param("price")float price, @Param("exchangeable")int exchangeable, @Param("_thing")int _thing, @Param("_id")int _id);



    //售卖商品交易无_thing
    int TthingsTransactionNoThing(@Param("finished_date")String finished_date, @Param("finished")int finished,
                                  @Param("_buyer")int _buyer, @Param("_id")int _id);


    //根据_id获取商品售卖详细信息不能显示商品图片
    TThings selectTthingsDetailByIdNoPhoto(@Param("_id")int _id);

    //根据finished来查找交易了的商品
    List<TThings> selectTThingsByFinished();

    //售卖商品交易
    Result TthingsTransaction(String finished_date, int finished, Integer _thing,
                              int _buyer, int seller, int _id);

    //添加交易记录
    int insertTradeInfo(TTrade ttrade);

    //添加交易记录无_thing
    int insertTradeInfoNoThing(TTrade ttrade);

    //根据_id获取用户信息，用来更新用户等级
    TUser selectUserGrade(@Param("_id")int _id);

    //发布售卖信息,等级加一
    int addUserGrade(@Param("grade")int grade, @Param("_id")int _id);
}
