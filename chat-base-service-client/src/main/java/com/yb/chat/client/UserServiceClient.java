package com.yb.chat.client; /**
 * Copyright (c) 2014-2018  墨博云舟 All Rights Reserved.
 */

import com.yb.chat.client.response.UserResp;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.yb.chat.client.UserServiceClient.PATH;

/**
 * com.yb.chat.client.UserServiceClient:
 *
 * @author yangbo
 * @version 1.00
 * @since 2018/1/24 0024 17:55
 */
@FeignClient(path = PATH)
public interface UserServiceClient {
    String PATH = "service/v1/test";
    @RequestMapping("/hello/{name}")
    List<UserResp> hello(@PathVariable("name") String name);
}
