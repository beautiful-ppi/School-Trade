package com.jinyuan.service.impl;

import com.jinyuan.domain.TSystemMessage;
import com.jinyuan.mapper.TSystemMessageMapper;
import com.jinyuan.service.TSystemMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Aaron
 * @description :
 * @Date 2020/5/28
 */
@Service
public class TSystemMessageServiceImpl implements TSystemMessageService {

    @Autowired
    TSystemMessageMapper tsystemMessageMapper;

    //用户查看自己的系统消息
    @Override
    public List<TSystemMessage> selectSystemMessageBy_id(int _user) {
            List<TSystemMessage> list= tsystemMessageMapper.selectSystemMessageBy_id(_user);
            return list;
    }

    //查看系统详情信息
    @Override
    public TSystemMessage selectDetailSystemMessage(int _id) {

            //已读
            tsystemMessageMapper.updateMessageIsRead(_id);

            TSystemMessage tSystemMessage=tsystemMessageMapper.selectDetailSystemMessage(_id);
            return tSystemMessage;
    }

    //设置为已读状态
    @Override
    public int updateMessageIsRead(int _id) {
        // TODO Auto-generated method stub
        return tsystemMessageMapper.updateMessageIsRead(_id);
    }


    //管理员发送系统消息
    @Override
    public int insertSystemMessage(int _user, String title, String message) {

        TSystemMessage tSystemMessage=new TSystemMessage();
        tSystemMessage.setIsRead(0);
        tSystemMessage.set_user(_user);
        tSystemMessage.setMessage(message);
        tSystemMessage.setTitle(title);

        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        tSystemMessage.setMessage_date(sdf.format(date));
        tSystemMessage.set_id((int)Math.round(Math.random()*100000000));

        return tsystemMessageMapper.insertSystemMessage(tSystemMessage);

    }
}
