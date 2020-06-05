package com.jinyuan.project.service.impl;

import com.jinyuan.project.domain.TThingsComplain;
import com.jinyuan.framework.web.Result;
import com.jinyuan.project.mapper.TThingsComplainMapper;
import com.jinyuan.project.service.TThingsComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author Aaron
 * @description :
 * @Date 2020/5/28
 */
@Service
public class TThingsComplainServiceImpl implements TThingsComplainService {

    @Autowired
    TThingsComplainMapper tthingsComplainMapper;

    //投诉
    @Override
    public int insertComplain(TThingsComplain tthingsComplain) {
        // TODO Auto-generated method stub
        return tthingsComplainMapper.insertComplain(tthingsComplain);
    }

    //投诉带图片
    @Override
    public Result insertComplainWithPhoto(int _id, String because, String memo,
                                          MultipartFile photo, HttpServletRequest request) {

        TThingsComplain tthingsComplain=new TThingsComplain();
        tthingsComplain.set_id((int)Math.round(Math.random()*100000000));
        tthingsComplain.set_thing(_id);
        tthingsComplain.setBecause(because);
        tthingsComplain.setMemo(memo);
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        tthingsComplain.setComplain_date(sdf.format(date));
        String photoname="";
        if(photo!=null) {
            try {
                photoname=photo.getOriginalFilename();
                photo.transferTo(new File(request.getSession().getServletContext().getRealPath("/images/" + photo.getOriginalFilename())));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        tthingsComplain.setPhoto(photoname);

        int row1=tthingsComplainMapper.insertComplainWithPhoto(tthingsComplain);
        //tthingsComplainMapper.insertComplain(tthingsComplain);
        int row2=tthingsComplainMapper.updateTthingsIsComplaint(_id);
        int row3=tthingsComplainMapper.updateTRequestIsComplaint(_id);

        if (row1>0&&row2>0&&row3>0){
            return Result.success("处理投诉成功",tthingsComplain.get_id());
        }
        return Result.error("处理投诉失败");

    }

    //调整售卖商品状态为被投诉
    @Override
    public int updateTthingsIsComplaint(int _id) {

        return tthingsComplainMapper.updateTthingsIsComplaint(_id);
    }

    //查看投诉信息
    @Override
    public Map<String, Object> selectComplaintInfos(int _thing) {
        Map<String,Object> map= tthingsComplainMapper.selectComplaintInfos(_thing);
        return map;
    }

    //调整需求商品状态为被投诉状态
    @Override
    public int updateTRequestIsComplaint(int _id) {

        return tthingsComplainMapper.updateTRequestIsComplaint(_id);
    }

}
