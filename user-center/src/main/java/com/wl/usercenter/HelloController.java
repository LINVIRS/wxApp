package com.wl.usercenter;

import com.wl.usercenter.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: HelloController @Description: TODO @Author: WangLinLIN @Date:
 * 2020/09/22 18:46:30  @Version: V1.0
 */
@RestController
public class HelloController implements ApplicationListener<WebServerInitializedEvent> {


  private int port ;
  @Override
  public void onApplicationEvent(WebServerInitializedEvent event) {
    port = event.getWebServer().getPort();
  }
  @GetMapping("/u1/{id}")
  public User getUser(@PathVariable("id") Integer id) {
//    System.out.println(port);
    return User.builder().id(id).wxNickname("浮生若梦").build();
  }



}
