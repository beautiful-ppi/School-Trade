package com.jinyuan;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@MapperScan("com.jinyuan.mapper")//扫描所有mapper包
@EnableCaching
@SpringBootApplication
public class SchoolTradeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolTradeApplication.class, args);
    }

}
