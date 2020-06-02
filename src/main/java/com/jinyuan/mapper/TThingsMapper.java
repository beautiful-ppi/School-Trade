package com.jinyuan.mapper;

import com.jinyuan.domain.TThings;
import com.jinyuan.domain.TTrade;
import com.jinyuan.domain.TUser;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface TThingsMapper {
    //被交换的物品改成交易状态
    int updateGetThingIsTradeState(@Param("finished_date")String finished_date, @Param("_thing")int _thing, @Param("_buyer")int _buyer, @Param("_id")int _id);

    //查找售卖人信息 (基本信息加此人d所有售卖信息)
    List<Map<String,Object>> selectSellerInfos(@Param("_id")int _id);

    //查看所有二手货售卖信息
    List<Map<String,Object>> selectAllTthings();

    //查看二手货售卖详情信息
    Map<String,Object> selectTthingsDetailById(@Param("_id")int _id);

    //添加二手货售卖信息
    int insertTthings(TThings tthings);

    //添加二手货售卖信息的同时添加图片
    //void insertMultiplePhoto(TThingsPhoto tThingsPhoto);

    //查看我的二手售卖信息
    List<Map<String,Object>> selectMyTthings(@Param("_owner")int _owner);

    //根据商品_id修改商品信息
    int updateMyTthingsNoThings(@Param("thing_name")String thing_name,@Param("new_old")float new_old,@Param("memo")String memo,
                                 @Param("price")float price,@Param("exchangeable")int exchangeable,@Param("_id")int _id);

    //根据商品_id修改商品信息
    int updateMyTthingsWithThings(@Param("thing_name")String thing_name,@Param("new_old")float new_old,@Param("memo")String memo,
                                   @Param("price")float price,@Param("exchangeable")int exchangeable,@Param("_thing")int _thing,@Param("_id")int _id);

    //根据商品_id修改商品带图片
    int updateMyThingsPictures(TThings tthings);

    //根据_id获取商品售卖详细信息不能显示商品图片
    TThings selectTthingsDetailByIdNoPhoto(@Param("_id")int _id);

    //根据finished来查找交易了的商品
    List<TThings> selectTThingsByFinished();

    //售卖商品交易
    int TthingsTransaction(@Param("finished_date")String finished_date,@Param("finished")int finished,@Param("_thing")Integer _thing,
                            @Param("_buyer")int _buyer,@Param("_id")int _id);

    //售卖商品交易无_thing
    int TthingsTransactionNoThing(@Param("finished_date")String finished_date,@Param("finished")int finished,
                                   @Param("_buyer")int _buyer,@Param("_id")int _id);

    //添加交易记录
    int insertTradeInfo(TTrade ttrade);

    //添加交易记录无_thing
    int insertTradeInfoNoThing(TTrade ttrade);

    //根据_id获取用户信息，用来更新用户等级
    TUser selectUserGrade(@Param("_id")int _id);

    //发布售卖信息,等级加一
    int addUserGrade(@Param("grade")int grade,@Param("_id")int _id);
}
