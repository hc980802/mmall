package com.hc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hc.mapper")
public class Mmall003Application {

    public static void main(String[] args) {
        SpringApplication.run(Mmall003Application.class, args);
    }

}
