package com.jinyuan.controller;

import com.jinyuan.framework.web.Result;
import com.jinyuan.service.impl.TThingsComplainResistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aaron
 * @description :
 * @Date 2020/5/28
 */
@RestController
@CrossOrigin
public class TThingsComplainResistController {
    @Autowired
    TThingsComplainResistServiceImpl tthingsComplainResistServiceImpl;


    //申诉
    @RequestMapping(value="insertComplainResist")
    public Result insertComplainResist(@RequestParam("complain")int complain,
                                       @RequestParam("resist")String resist, @RequestParam("thing")int thing){

        return tthingsComplainResistServiceImpl.insertComplainResist(complain, resist, thing);
    }

}
