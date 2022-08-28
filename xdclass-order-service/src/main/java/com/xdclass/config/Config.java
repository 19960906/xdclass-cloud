package com.xdclass.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: czr
 * @CreateTime: 2022-07-25  21:52
 * @Description: TODO
 * @Version: 1.0
 */
@Configuration
public class Config {

    @Bean
    @LoadBalanced//添加了该注解后就有了负载均衡功能
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}
