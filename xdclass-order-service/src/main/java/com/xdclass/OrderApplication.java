package com.xdclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @Author: czr
 * @CreateTime: 2022-07-24  21:11
 * @Description: 订单服务启动类
 * @Version: 1.0
 */
@SpringBootApplication
//注解的作用：让注册中心发现这个服务
@EnableDiscoveryClient
//开启Fegin支持
@EnableFeignClients
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }

}
