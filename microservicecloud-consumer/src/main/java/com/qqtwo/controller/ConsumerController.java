package com.qqtwo.controller;

import com.qqtwo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: 姜光明
 * @Date: 2019/4/24 21:57
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-USER";

//    @GetMapping("{id}")
//    public User queryById(@PathVariable("id") Long id) {
//        String url = "http://localhost:8001/user/"+id;
//      return   restTemplate.getForObject(url, User.class);
//    }

    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id) {
//
//        List<String> list = discoveryClient.getServices();
//        System.out.println("*********"+list);
//
//
//        //根据服务id(spring.application.name)来获取服务实例
//        List<ServiceInstance> instances = discoveryClient.getInstances("microservicecloud-user");
//        //取出一个服务实例
//        ServiceInstance instance = instances.get(0);
//        //从实例中获取host和port,组成url
//        String url = String.format("http://%s:%s/user/%s", instance.getHost(), instance.getPort(), id);

        String url="http://microservicecloud-user/user/"+id;

        return restTemplate.getForObject(url, User.class);
    }


}
