package com.wl.contentcenter.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;

public class UserCenterconfig {
    @Bean
    public Logger.Level level(){
        return Logger.Level.FULL;
    }
}
