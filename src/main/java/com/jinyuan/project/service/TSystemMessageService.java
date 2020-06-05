package com.jinyuan.project.service;


import com.jinyuan.project.domain.TSystemMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TSystemMessageService {
    //用户查看自己的系统消息
    List<TSystemMessage> selectSystemMessageBy_id(@Param("_user")int _user);

    //查看系统消息详情
    TSystemMessage selectDetailSystemMessage(@Param("_id")int _id);

    //设置为已读状态
    int updateMessageIsRead(@Param("_id")int _id);

    //管理员发送系统消息
    int insertSystemMessage(int _user, String title, String message);
}
