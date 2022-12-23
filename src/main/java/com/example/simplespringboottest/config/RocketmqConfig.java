package com.example.simplespringboottest.config;


import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class RocketmqConfig {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Bean
    public RocketMQTemplate getRocketMQTemplate(){
        rocketMQTemplate = new RocketMQTemplate();
        return rocketMQTemplate;
    }

}
