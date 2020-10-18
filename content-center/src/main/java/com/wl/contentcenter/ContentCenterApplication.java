package com.wl.contentcenter;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wl.contentcenter.config.UserCenterconfig;
import com.wl.contentcenter.openFegin.UserFegin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(defaultConfiguration = UserCenterconfig.class)

public class ContentCenterApplication {

  public static void main(String[] args) {
    SpringApplication.run(ContentCenterApplication.class, args);
  }

  @Bean
  @LoadBalanced
  public RestTemplate getRestTemplate() {
    return new RestTemplate();
  }

  @Bean
  public JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
    return new JPAQueryFactory(entityManager);
  }
}
