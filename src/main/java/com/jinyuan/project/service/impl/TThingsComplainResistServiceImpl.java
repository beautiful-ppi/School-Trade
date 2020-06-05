package com.jinyuan.project.service.impl;

import com.jinyuan.project.domain.TThingsComplainResist;
import com.jinyuan.framework.web.Result;
import com.jinyuan.project.mapper.TThingsComplainResistMapper;
import com.jinyuan.project.service.TThingsComplainResistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TThingsComplainResistServiceImpl implements TThingsComplainResistService {

    @Autowired
    TThingsComplainResistMapper tthingsComplainResistMapper;

    //申诉
    @Override
    public Result insertComplainResist(int _complain, String resist, int _thing) {
        // TODO Auto-generated method stub
        //tthingsComplainResistMapper.insertComplainResist(tthingsComplainResist);
        String result=null;
        TThingsComplainResist tthingsComplainResist=new TThingsComplainResist();
        tthingsComplainResist.set_id((int)Math.round(Math.random()*100000000));
        tthingsComplainResist.set_complain(_complain);
        tthingsComplainResist.setResist(resist);
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        tthingsComplainResist.setResist_date(sdf.format(date));


            int row1=tthingsComplainResistMapper.insertComplainResist(tthingsComplainResist);
            //更新商品是否申诉状态
            int row2=tthingsComplainResistMapper.updateRequestIsResist(_thing);
            int row3=tthingsComplainResistMapper.updateThingsIsResist(_thing);
        if (row1>0&&row2>0&&row3>0){
            return Result.success("申诉处理成功",tthingsComplainResist.get_id());
        }
            return Result.error("申诉处理失败");
    }

    //调整售卖商品为已申诉状态
    @Override
    public int updateThingsIsResist(int _id) {

        return tthingsComplainResistMapper.updateThingsIsResist(_id);
    }

    //调整需求商品为已申诉状态
    @Override
    public int updateRequestIsResist(int _id) {

        return tthingsComplainResistMapper.updateRequestIsResist(_id);
    }

}
