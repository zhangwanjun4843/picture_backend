package com.example.picture;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@MapperScan("com.example.picture.mapper")
@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class PictureApplication {

    public static void main(String[] args) {
        SpringApplication.run(PictureApplication.class, args);
    }

}
