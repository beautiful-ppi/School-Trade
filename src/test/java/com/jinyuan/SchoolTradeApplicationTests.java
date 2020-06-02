package com.jinyuan;

import com.jinyuan.service.impl.TManegerServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SchoolTradeApplicationTests {

    @Autowired
    TManegerServiceImpl tManegerService;

    @Test
    void contextLoads() {
        tManegerService.deleteManagerById(22375449);
    }

}
