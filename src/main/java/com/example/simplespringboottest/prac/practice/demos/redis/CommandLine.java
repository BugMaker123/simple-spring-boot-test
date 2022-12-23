/*
package com.example.simplespringboottest.prac.practice.demos.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;

*/
/**
 * @ ClassName: ComdLine
 * @Author: legen
 * @Date: 2020/11/11
 *//*

@Configuration
public class CommandLine {
    @Autowired
    RedisTemplate redisTemplate;
    @Bean
    public CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                redisTemplate.opsForValue().set("test","String 类型");
                Set set = redisTemplate.keys("test");
                for (Object str :set){
                    System.out.println(redisTemplate.opsForValue().get(str));
                }
            }
        };
    }
}
*/
