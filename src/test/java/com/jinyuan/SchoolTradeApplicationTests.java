package com.jinyuan;

import com.jinyuan.project.service.impl.TManegerServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

@SpringBootTest
class SchoolTradeApplicationTests {

    @Autowired
    TManegerServiceImpl tManegerService;

    @Test
    void contextLoads() {
        tManegerService.deleteManagerById(22375449);
    }

    @Test
    void mytest(){
        try {
            String path = ResourceUtils.getURL("classpath:").getPath();
            System.out.println("path1="+path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
