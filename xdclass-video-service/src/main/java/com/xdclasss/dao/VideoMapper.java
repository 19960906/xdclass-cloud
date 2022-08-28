package com.xdclasss.dao;

import com.xdclass.domain.Video;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: czr
 * @CreateTime: 2022-07-24  20:53
 * @Description: dao接口
 * @Version: 1.0
 */
public interface VideoMapper {

    /**
     * @description:
     * @author:
     * @date: 2022/7/24 20:55
     * @param: videoId: id
     * @return: video实体
     **/
    @Select("select * from video where id=#{videoId}")
    Video findById(int videoId);
}
