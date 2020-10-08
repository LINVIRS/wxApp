package com.wl.contentcenter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.AsyncRestTemplate;

/**
 * @ClassName: AsyncRestTemplateConfig
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/10/08 10:16:56 
 * @Version: V1.0
 **/
@Configuration
public class AsyncRestTemplateConfig {
    @Bean
    public AsyncRestTemplate asyncRestTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        //设置链接超时时间
        factory.setConnectTimeout(100);
        //设置读取资料超时时间
        factory.setReadTimeout(200);
        //设置异步任务（线程不会重用，每次调用时都会重新启动一个新的线程）
        factory.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return new AsyncRestTemplate(factory);
    }

}
