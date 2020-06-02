package com.jinyuan.controller;

import com.jinyuan.domain.TSystemMessage;
import com.jinyuan.framework.web.Result;
import com.jinyuan.service.impl.TSystemMessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Aaron
 * @description :
 * @Date 2020/5/28
 */
@RestController
@CrossOrigin
public class TSystemMessageController {
    @Autowired
    TSystemMessageServiceImpl tSystemMessageServiceImpl;


    //管理员发送系统消息
    @RequestMapping(value="insertSystemMessage")
    public Result insertSystemMessage(@RequestParam("_user")int _user, @RequestParam("title")String title,
                                      @RequestParam("message")String message){
        int row= tSystemMessageServiceImpl.insertSystemMessage(_user, title, message);
        if (row>0){
            return Result.success("管理员发送系统消息成功！");
        }
        return Result.error("管理员发送系统消息失败！");
    }


    //查看系统信息详情
    @RequestMapping(value="selectDetailSystemMessage/{_id}")
    public Result selectDetailSystemMessage(@PathVariable("_id")int _id){
        TSystemMessage tSystemMessage= tSystemMessageServiceImpl.selectDetailSystemMessage(_id);
        return Result.success("查看系统信息详情",tSystemMessage);
    }

    //用户查看自己的系统信息
    @RequestMapping(value="selectSystemMessageBy_id/{_user}")
    public Result selectSystemMessageBy_id(@PathVariable("_user")int _user){
        List<TSystemMessage> list= tSystemMessageServiceImpl.selectSystemMessageBy_id(_user);
        return Result.success("系统信息",list);
    }
}
