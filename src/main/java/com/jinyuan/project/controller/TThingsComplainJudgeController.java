package com.jinyuan.project.controller;

import com.jinyuan.framework.web.Result;
import com.jinyuan.project.service.impl.TThingsComplainJudgeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * @author Aaron
 * @description :
 * @Date 2020/5/28
 */
@RestController
@CrossOrigin
public class TThingsComplainJudgeController {
    @Autowired
    TThingsComplainJudgeServiceImpl tthingsComplainJudgeServiceImpl;

    //对商品进行仲裁
    @RequestMapping(value="insertJudgeResult")
    public Result insertJudgeResult(@RequestParam("_complain")int _complain, @RequestParam("judge")String judge,
                                    @RequestParam("thing_id")int thing_id){

        return tthingsComplainJudgeServiceImpl.insertJudgeResult(_complain, judge, thing_id);
    }


    //设置为已调解状态
    @RequestMapping(value="updateStateToAccepted/{_complain}")
    public Result updateStateToAccepted(@PathVariable("_complain")int _complain){

        return tthingsComplainJudgeServiceImpl.updateStateToAccepted(_complain);
    }

    //根据complain_id查看投诉申诉详情
    @RequestMapping(value="selectDetailComplainAndResistByComplain_id/{_id}")
    public Result selectDetailComplainAndResistByComplain_id(@PathVariable("_id")int _id) {

        Map<String, Object> map= tthingsComplainJudgeServiceImpl.selectDetailComplainAndResistByComplain_id(_id);
        return Result.success("查看投诉申诉详情",map);
    }

    //未调解的投诉和申诉信息
    @RequestMapping(value="selectComplainAndResistNoAccepted")
    public Result selectComplainAndResistNoAccepted() {

        List<Map<String,Object>> mapList= tthingsComplainJudgeServiceImpl.selectComplainAndResistNoAccepted();
        return Result.success("未调解的投诉和申诉信息",mapList);
    }

    //接受调解的投诉和申诉信息
    @RequestMapping(value="selectComplainAndResistWithAccepted")
    public Result selectComplainAndResistWithAccepted() {

        List<Map<String,Object>> mapList= tthingsComplainJudgeServiceImpl.selectComplainAndResistWithAccepted();
        return Result.success("接受调解的投诉和申诉信息",mapList);
    }

    //查看所有投诉和申诉信息
    @RequestMapping(value="selectAllComplainAndResist")
    public Result selectAllComplainAndResist() {

        List<Map<String,Object>> mapList=  tthingsComplainJudgeServiceImpl.selectAllComplainAndResist();
        return Result.success("查看所有投诉和申诉信息",mapList);
    }

    //查看申诉商品的仲裁结果
    @RequestMapping(value="selectThingsJudge/{_thing}")
    public Result selectThingsJudge(@PathVariable("_thing")int _thing){
        Map<String,Object> map=  tthingsComplainJudgeServiceImpl.selectThingsJudge(_thing);
        return Result.success("查看申诉商品的仲裁结果",map);
    }
}
