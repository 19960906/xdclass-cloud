package com.xdclass.service;

import com.xdclass.domain.Video;
import com.xdclass.service.fallback.VideoServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description: 申明这是一个feign的客户端，value：注册到注册中心服务的名字
 *              这里是 order 服务调用 video 服务
 * @author:  Mr.Chen
 * @date: 2022/7/27 22:59
 * @return:
 **/
//fallback:这里配置的是服务出问题后会调用的类
//value:调用的服务名称,就是配置文件中配置的服务名称(也是注册到注册中心的名称)
@FeignClient(value = "xdclass-video-service",fallback = VideoServiceFallback.class)
public interface VideoService {

    /**
     * @description:
     * @date: 2022/7/28 22:11
     * @param: videoId
     * @return: com.xdclass.domain.Video
     **/
    @GetMapping("/api/v1/video/findById")
    Video findById(@RequestParam("videoId")int videoId);

    /**
     * @description: 保存
     * @date: 2022/7/28 22:19
     * @param: video
     **/
    @PostMapping("/api/v1/video/save")
    int save(@RequestBody Video video);
}
