package com.bookmanger.springbootbookmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bookmanger.springbootbookmanager.mapper")

public class SpringbootBookmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBookmanagerApplication.class, args);
    }

}
