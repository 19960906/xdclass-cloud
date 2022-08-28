package com.xdclass.service.fallback;

import com.xdclass.domain.Video;
import com.xdclass.service.VideoService;
import org.springframework.stereotype.Service;

/**
 *处理 VideoService 熔断后的方法
 * @return: null
 * @date: 2022/8/3 21:30
 * @since 1.0
 */
@Service
public class VideoServiceFallback implements VideoService {
    @Override
    public Video findById(int videoId) {
        Video video = new Video();
        video.setTitle("这是Fallback里面的视频信息");
        return video;
    }

    @Override
    public int save(Video video) {
        return 0;
    }
}