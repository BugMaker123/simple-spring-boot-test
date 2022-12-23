package com.example.simplespringboottest.mq;/*

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


/**
 * @ ClassName: MsgCustomer
 * @Author: legen
 * @Date: 2020/10/22
 */

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RabbitListener
public class MsgCustomer {

    @RabbitHandler
    @RabbitListener(queues="dyhQueue")
    public void process(String msg){
        System.out.println(LocalDate.now().toString()+msg);
    }
}

