package com.qqtwo.client;

import com.qqtwo.config.FeignConfig;
import com.qqtwo.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: 姜光明
 * @Date: 2019/4/26 21:18
 */
//开启feign功能
@FeignClient(value = "MICROSERVICECLOUD-USER",fallback = UserClient.UserClientFallback.class,configuration = FeignConfig.class)
public interface UserClient {

    @GetMapping("user/{id}")
    String queryById(@PathVariable("id")Long id);

    @Component
    class UserClientFallback implements UserClient {
        @Override
        public String queryById(Long id) {
            return "真的很忙啊！别来了.。。。。。。。。。。。。。。。";
        }
    }

}
