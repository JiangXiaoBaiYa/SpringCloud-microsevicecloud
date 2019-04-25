package com.qqtwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: 姜光明
 * @Date: 2019/4/24 21:16
 */
@EnableDiscoveryClient  // 开启Eureka客户端发现功能
@SpringBootApplication
@MapperScan("com.qqtwo.user.mapper")
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}
