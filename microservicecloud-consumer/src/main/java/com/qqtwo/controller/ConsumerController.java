package com.qqtwo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.qqtwo.client.UserClient;
import com.qqtwo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
//@DefaultProperties(defaultFallback = "queryByIdFallBack")
public class ConsumerController {
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Autowired
//    private DiscoveryClient discoveryClient;
//
//    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-USER";

//    @GetMapping("{id}")
//    public User queryById(@PathVariable("id") Long id) {
//        String url = "http://localhost:8001/user/"+id;
//      return   restTemplate.getForObject(url, User.class);
//    }


//    public String queryByIdFallBack(@PathVariable("id") Long id) {
//        return "对不起，网络太拥挤了，请稍后再试试";
//    }

//    public String queryByIdFallBack(Long id) {
//        return "对不起，网络太拥挤了，请稍后再试试";
//    }
    public String queryByIdFallBack() {
        return "对不起，网络太拥挤了，请稍后再试试";
    }

    @Autowired
    private UserClient userClient;

    @GetMapping("{id}")
    public String queryById(@PathVariable("id") Long id) {
//        try {
//            Thread.sleep(2600);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return userClient.queryById(id);
    }

//    @GetMapping("{id}")
//    @HystrixCommand(commandProperties = {   //服务熔断的条件：触发熔断的最小请求次数，默认20，现在我们改成了10  休眠时间默认为5秒，我们改成了10秒
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
//    })
//    public String queryById(@PathVariable("id") Long id) {
//        if(id==1){
//            throw new RuntimeException();
//        }
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


        /*try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/
//        String url="http://microservicecloud-user/user/"+id;
//
//        return restTemplate.getForObject(url, String.class);
//    }


}
