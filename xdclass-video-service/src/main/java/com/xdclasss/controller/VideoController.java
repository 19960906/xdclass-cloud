package com.xdclasss.controller;

import com.xdclass.domain.Video;
import com.xdclasss.service.VideoService;
import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: czr
 * @CreateTime: 2022-07-24  17:48
 * @Description: 视频
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/v1/video")
public class VideoController {

    @Resource
    private VideoService videoService;


    @RequestMapping("/findById")
    public Video findById(int videoId, HttpServletRequest request) {
        Video byId = videoService.findById(videoId);
        //方便大家发现请求是那台机器
        byId.setServerInfo(request.getServerName()+":"+request.getServerPort());
        return byId;
    }

    @PostMapping("/save")
    public int save(@RequestBody Video video){
        System.out.println(video.getTitle());
        return 1;
    }


}
