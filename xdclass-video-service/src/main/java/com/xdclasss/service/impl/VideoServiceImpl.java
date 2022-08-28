package com.xdclasss.service.impl;

import com.xdclass.domain.Video;
import com.xdclasss.dao.VideoMapper;
import com.xdclasss.service.VideoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: czr
 * @CreateTime: 2022-07-24  20:53
 * @Description: 视频实现
 * @Version: 1.0
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Resource
    private VideoMapper videoMapper;

    @Override
    public Video findById(int videoId) {
        Video byId = videoMapper.findById(videoId);
        return byId;
    }
}
