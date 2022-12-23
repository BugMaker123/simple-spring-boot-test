package com.example.simplespringboottest.prac.message.rabbitmq.helloworld1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.230.101");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");

        Connection connection = null;
        Channel channel = null;
        try {
            // 创建连接
            connection = factory.newConnection();
            // 创建通道
            channel = connection.createChannel();
            // 通过通道声明交换机
            // 参数1：队列名称
            // 参数二：是否持久化
            // 参数三：是否独占队列
            // 参数四：是否在消费完成后自动删除队列
            // 参数五：其他参数
            channel.queueDeclare("dyhTestQueue", false, false, false, null);
            // 发送消息
            String message = "测试111111";
            // 参数1：交换机名称 参数2：队列名称 参数3：传递消息额外设置 参数4：消息的具体内容
            channel.basicPublish("", "dyhTestQueue", null, message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            channel.close();
            // 创建队列
            connection.close();
        }
    }
}