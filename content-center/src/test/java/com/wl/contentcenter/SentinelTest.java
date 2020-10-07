package com.wl.contentcenter;

import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: sad
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/10/06 16:15:26 
 * @Version: V1.0
 **/
public class SentinelTest {
    public static void main(String[] args) throws InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        for (int i = 0; i < 100; i++) {
            String object = restTemplate.getForObject("http://localhost:8086/actuator/sentinel", String.class);
            Thread.sleep(1000);
        }
    }
}