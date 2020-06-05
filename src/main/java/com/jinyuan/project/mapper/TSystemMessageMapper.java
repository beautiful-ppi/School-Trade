package com.jinyuan.project.mapper;

import com.jinyuan.project.domain.TSystemMessage;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TSystemMessageMapper {
    //用户查看自己的系统消息
    List<TSystemMessage> selectSystemMessageBy_id(@Param("_user")int _user);

    //查看系统消息详情
    TSystemMessage selectDetailSystemMessage(@Param("_id")int _id);

    //设置为已读状态
    int updateMessageIsRead(@Param("_id")int _id);

    //
    int insertSystemMessage(TSystemMessage tSystemMessage);
}
