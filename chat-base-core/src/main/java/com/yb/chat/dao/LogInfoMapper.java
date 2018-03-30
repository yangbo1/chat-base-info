/**
 * Copyright (c) 2014-2018  墨博云舟 All Rights Reserved.
 */
package com.yb.chat.dao;

import com.yb.chat.client.response.CountUserResp;
import com.yb.chat.client.response.LogResp;
import com.yb.chat.entity.LogInfo;
import com.yb.common.dao.MyMapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * LogInfoMapper:
 *
 * @author yangbo
 * @version 1.00
 * @since 2018/2/22 0022 16:49
 */
public interface LogInfoMapper extends MyMapper<LogInfo> {

    List<LogResp> findLog(@Param("name") String name, @Param("sort") String sort);

    /**
     * 统计每天在线人数
     * @return
     */
    List<CountUserResp> getCountUserByDay();
    /**
     * 统计每天登录人次
     * @return
     */
    List<CountUserResp> getCountTimesByDay();
}
