package com.jinyuan.controller;

import com.jinyuan.framework.web.Result;
import com.jinyuan.service.impl.TThingsComplainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * @author Aaron
 * @description :
 * @Date 2020/5/28
 */
@RestController
@CrossOrigin
public class TThingsComplainController {
    @Autowired
    TThingsComplainServiceImpl tthingsComplainServiceImpl;


    //查看投诉信息
    @RequestMapping(value="selectComplaintInfos/{thing}")
    public Result selectComplaintInfos(@PathVariable("thing")int thing){
        Map<String, Object> map= tthingsComplainServiceImpl.selectComplaintInfos(thing);
        return Result.success("投诉信息",map);
    }


    //投诉
    @RequestMapping(value="insertComplain")
    public Result insertComplain(@RequestParam("id")int id, @RequestParam("because")String because,
                                 @RequestParam(required=false,value="memo")String memo, @RequestParam(required=false,value="photo") MultipartFile photo,
                                 HttpServletRequest request) {


        return tthingsComplainServiceImpl.insertComplainWithPhoto(id, because, memo, photo,request);
    }
}
