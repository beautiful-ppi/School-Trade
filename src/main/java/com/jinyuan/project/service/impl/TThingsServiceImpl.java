package com.jinyuan.project.service.impl;

import com.jinyuan.project.domain.TThings;
import com.jinyuan.project.domain.TTrade;
import com.jinyuan.project.domain.TUser;
import com.jinyuan.framework.web.Result;
import com.jinyuan.project.mapper.TThingsMapper;
import com.jinyuan.project.service.TThingsService;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aaron
 * @description :
 * @Date 2020/5/28
 */
@Service
public class TThingsServiceImpl implements TThingsService {

    @Autowired
    TThingsMapper tthingsMapper;

    private static final Logger log= LoggerFactory.getLogger(TThingsServiceImpl.class);
    //查找所有二手货售卖信息
    @Override
    public List<Map<String, Object>> selectAllTthings() {

        List<Map<String,Object>> mapList=tthingsMapper.selectAllTthings();
        return mapList;
    }

    //查看二手货售卖详情信息
    @Override
    public Map<String, Object> selectTthingsDetailById(int _id) {
        Map<String,Object> map=tthingsMapper.selectTthingsDetailById(_id);
       return map;
    }

    //添加二手售卖信息
    @Override
    public Result insertTthings(int _owner, String thing_name, float new_old,
                                String memo, float price, int exchangeable, MultipartFile[] photos,
                                HttpServletRequest request) {
        TThings tthings=new TThings();
        tthings.set_id((int)Math.round(Math.random()*100000000));
        tthings.set_owner(_owner);
        tthings.setThing_name(thing_name);
        tthings.setNew_old(new_old);
        tthings.setMemo(memo);
        tthings.setPrice(price);
        tthings.setExchangeable(exchangeable);
        tthings.setFinished(0);
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        tthings.setPublish_date(sdf.format(date));

        //HashMap<String,String> photoNameMap=new HashMap<>();

        try {
            if (photos.length>0){
                for (MultipartFile photo:photos){
                    /*Integer i=1++;

                    String ptname= "photo"+i.toString();
                    photoNameMap.put(ptname,photo.getOriginalFilename());
                    */

                    String photoname=_owner+"-"+photo.getOriginalFilename();
                    String path="D:\\imagesUpload\\thingsImages\\"+tthings.get_id();
                    File dir=new File(path);
                    //判断是否存在目录
                    if (!dir.exists()){
                        dir.mkdir();
                    }
                    //保存文件
                    File file=new File(dir,photoname);
                    //是否存在文件
                    if (!file.exists()){
                        photo.transferTo(file);
                    }
                }
            }
        }catch(Exception e) {
           e.printStackTrace();
        }
            int row=tthingsMapper.insertTthings(tthings);
            if (row>0){
                return Result.success("添加成功！",tthings.get_id());
            }
           return Result.error("添加失败！");
    }



    //查看我的二手售卖信息
    @Override
    public List<Map<String, Object>> selectMyTthings(int _owner) {

        List<Map<String,Object>> mapList=tthingsMapper.selectMyTthings(_owner);
        return mapList;
    }

    //根据_id获取商品售卖详细信息不能显示商品图片
    @Override
    public TThings selectTthingsDetailByIdNoPhoto(int _id) {

        return tthingsMapper.selectTthingsDetailByIdNoPhoto(_id);
    }

    //根据finished来查找交易了的商品
    @Override
    public List<TThings> selectTThingsByFinished() {

        return tthingsMapper.selectTThingsByFinished();
    }

    //售卖商品交易
    @Override
    public Result TthingsTransaction(String finished_date, int finished, Integer _thing, int _buyer, int seller, int _id) {


            if(_thing==null) {
                //现金交易
                int row=tthingsMapper.TthingsTransactionNoThing(finished_date, finished, _buyer, _id);
                if (row>0){
                    return Result.success("交易成功！",_id);
                }
                return Result.error("交易失败！");
            }else {
                //物物交换
                int row1=tthingsMapper.TthingsTransaction(finished_date, finished, _thing, _buyer, _id);
                int row2=tthingsMapper.updateGetThingIsTradeState(finished_date,_id ,seller,_thing);
                if (row1>0&&row2>0){
                    return Result.success("交易成功！",_id);
                }
                return Result.error("交易失败");
            }


    }

    //根据_id获取用户信息，用来更新用户等级
    @Override
    public TUser selectUserGrade(int _id) {

        return tthingsMapper.selectUserGrade(_id);
    }

    //发布售卖信息，等级加一
    @Override
    public int addUserGrade(int grade, int _id) {

        return tthingsMapper.addUserGrade(grade, _id);
    }

    @Override
    public List<Map<String, Object>> selectSellerInfos(int _id) {

            List<Map<String,Object>> mapList=tthingsMapper.selectSellerInfos(_id);

        return mapList;
    }

    @Override
    public int insertTradeInfo(TTrade ttrade) {

       return tthingsMapper.insertTradeInfo(ttrade);
    }

    @Override
    public int TthingsTransactionNoThing(String finished_date, int finished, int _buyer, int _id) {

        return tthingsMapper.TthingsTransactionNoThing(finished_date, finished, _buyer, _id);
    }

    @Override
    public int insertTradeInfoNoThing(TTrade ttrade) {

       return tthingsMapper.insertTradeInfoNoThing(ttrade);
    }

    //修改商品
    @Override
    public Result updateMyTthingsNoThings(String thing_name, float new_old, String memo, float price, int exchangeable,
                                          int _id, MultipartFile[] photo1,
                                          HttpServletRequest request) {

        TThings tthings=new TThings();
        tthings.set_id(_id);
        tthings.setThing_name(thing_name);
        tthings.setNew_old(new_old);
        tthings.setMemo(memo);
        tthings.setPrice(price);
        tthings.setExchangeable(exchangeable);

        try {
            if(photo1==null) {
                //无图片修改
                tthingsMapper.updateMyTthingsNoThings(thing_name, new_old, memo, price, exchangeable, _id);
            }else {
                //带图片修改
                if(photo1.length==1&&photo1[0]!=null){
                    photo1[0].transferTo(new File(request.getSession().getServletContext().getRealPath("/images/"+photo1[0].getOriginalFilename())));
                    tthings.setPicture1(photo1[0].getOriginalFilename());
                }else if(photo1.length==2&&photo1[0]!=null&&photo1[1]!=null){

                    photo1[0].transferTo(new File(request.getSession().getServletContext().getRealPath("/images/"+photo1[0].getOriginalFilename())));
                    tthings.setPicture1(photo1[0].getOriginalFilename());

                    photo1[1].transferTo(new File(request.getSession().getServletContext().getRealPath("/images/"+photo1[1].getOriginalFilename())));
                    tthings.setPicture2(photo1[1].getOriginalFilename());

                }else if(photo1.length==3&&photo1[0]!=null&&photo1[1]!=null&&photo1[2]!=null){

                    photo1[0].transferTo(new File(request.getSession().getServletContext().getRealPath("/images/"+photo1[0].getOriginalFilename())));
                    tthings.setPicture1(photo1[0].getOriginalFilename());

                    photo1[1].transferTo(new File(request.getSession().getServletContext().getRealPath("/images/"+photo1[1].getOriginalFilename())));
                    tthings.setPicture2(photo1[1].getOriginalFilename());

                    photo1[2].transferTo(new File(request.getSession().getServletContext().getRealPath("/images/"+photo1[2].getOriginalFilename())));
                    tthings.setPicture3(photo1[2].getOriginalFilename());
                }

            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        int row=tthingsMapper.updateMyThingsPictures(tthings);
        if (row>0){
            return Result.success("商品修改成功！",_id);
        }
        return Result.error("商品修改失败！");

    }

    @Override
    public int updateMyTthingsWithThings(String thing_name, float new_old, String memo, float price, int exchangeable,
                                         int _thing, int _id) {

        return tthingsMapper.updateMyTthingsWithThings(thing_name, new_old, memo, price, exchangeable, _thing, _id);
    }
}
