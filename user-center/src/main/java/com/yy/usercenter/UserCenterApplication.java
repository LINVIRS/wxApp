package com.yy.usercenter;

import com.purgeteam.dispose.starter.annotation.EnableGlobalDispose;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(value = "com.yy.usercenter.mapper")

public class UserCenterApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserCenterApplication.class, args);
  }
}
