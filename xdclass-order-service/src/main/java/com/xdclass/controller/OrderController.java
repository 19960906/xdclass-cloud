package com.xdclass.controller;

import com.xdclass.domain.Video;
import com.xdclass.domain.VideoOrder;
import com.xdclass.service.VideoService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author: czr
 * @CreateTime: 2022-07-24  21:15
 * @Description: 订单
 * @Version: 1.0
 */
@RestController
@RequestMapping("api/v1/video_order")
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    /**
     * 该注解可以获取到服务列表
     **/
    @Resource
    private DiscoveryClient discoveryClient;

    /**
     *  使用feign调用
     **/
    @Resource
    private VideoService videoService;

    @RequestMapping("/save")
    public Object findById(int videoId){
//        Video video = restTemplate.getForObject("http://127.0.0.1:9000/api/v1/video/findById?videoId=" + videoId, Video.class);

//        List<ServiceInstance> instances = discoveryClient.getInstances("xdclass-video-service");
//        ServiceInstance serviceInstance = instances.get(0);

        //这里不能使用ip+端口的方式调用，只能使用 服务名 调用（前提是没有加 @LoadBalanced 这个注解，加了以后就只能使用服务名调用了）
//        Video video = restTemplate.getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/api/v1/video/findById?videoId=" + videoId, Video.class);
//        Video video = restTemplate.getForObject("http://xdclass-video-service/api/v1/video/findById?videoId=" + videoId, Video.class);
        Video video = videoService.findById(videoId);
        VideoOrder videoOrder = new VideoOrder();
            videoOrder.setVideoId(video.getId());
            videoOrder.setVideoTitle(video.getTitle());
            videoOrder.setCreateTime(new Date());
            videoOrder.setServerInfo(video.getServerInfo());
            return videoOrder;
    }

//    /**
//     * @description:测试 feign 调用 使用post方式传输对象
//      * @date: 2022/7/28 22:21
//      * @param: video
//      * @return: java.lang.Object
//     **/
//    @RequestMapping("/save")
//    public Object save(@RequestBody Video video){
//        int save = videoService.save(video);
//        Map<String,Integer> map = new HashMap<>();
//        map.put("rows",save);
//        return map;
//    }

    int temp = 0;
    @RequestMapping("/list")
    public Object list(HttpServletRequest request){
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//
//        }
        temp ++;
        if (temp%3==0){
//            throw new RuntimeException("异常错误");
        }
        Map<String,String> map = new HashMap<>();
        map.put("title","1");//asdf
        map.put("title2","2");
        map.put("title3","2");
        map.put("title4","2");
        map.put("port",request.getServerPort()+"");
        return map;
    }
}
