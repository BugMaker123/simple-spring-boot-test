package com.example.simplespringboottest.springtests.facoryBeanTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlgorithmConfig {
    @Bean
    public AlgorithmFactoryBean algorithmFactoryBean() {
        AlgorithmFactoryBean algorithmFactoryBean = new AlgorithmFactoryBean();
        algorithmFactoryBean.setAlgorithmType("MD5");
        return algorithmFactoryBean;
    }
}
