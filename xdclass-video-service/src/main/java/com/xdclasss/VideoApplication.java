package com.xdclasss;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @Author: czr
 * @CreateTime: 2022-07-24  17:48
 * @Description:
 * @Version: 1.0
 */
@SpringBootApplication
@MapperScan("com.xdclasss.dao")
//注解的作用：让注册中心发现这个服务
@EnableDiscoveryClient
public class VideoApplication {
    public static void main(String[] args) {
        System.out.println("");
        SpringApplication.run(VideoApplication.class,args);
    }
}
