package com.wl.contentcenter;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName: ContentController
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/09/23 09:43:23 
 * @Version: V1.0
 **/
@RestController
public class ContentController {
    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private RestTemplate restTemplate;
//    @GetMapping("/c1")
//    public String getInstance() {
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-center");
////     String targetUrl  = instances.stream().map(i -> i.getUri().toString() + "/u1").findFirst()
////                .orElseThrow(() -> new IllegalArgumentException("没有实例"));
//        List<URI> collect = instances.stream().map(i -> i.getUri()).collect(Collectors.toList());
//        Random random =new Random();
//        int i1 = random.nextInt(collect.size());
//        String string = collect.get(i1).toString();
//        return  restTemplate.getForObject(string+"/u1",String.class);
//    }

    @GetMapping("/c2")
    public String getInstance() {

        return  restTemplate.getForObject("http://user-center/u1",String.class);
    }
}
