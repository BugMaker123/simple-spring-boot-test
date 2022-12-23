package com.example.simplespringboottest.mq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MsgCustomerTest {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void dealMsg() {
        while (true) {
            Message message = rabbitTemplate.receive("dyhQueue", 2000L);
            if (message != null) {
                System.out.println(message.getMessageProperties());
            }
        }
    }
}
