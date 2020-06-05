package com.jinyuan;

import com.jinyuan.project.mapper.TUserMapper;
import com.jinyuan.project.service.impl.TManegerServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SchoolTradeApplicationTests {

    @Autowired
    TManegerServiceImpl tManegerService;
    @Autowired
    TUserMapper tUserMapper;

    @Test
    void contextLoads() {
        tManegerService.deleteManagerById(22375449);
    }

    @Test
    void sqltest(){
       Map<String,Object> map= tUserMapper.selectAllUserGrade();
        System.out.println("map"+map);
    }

}
