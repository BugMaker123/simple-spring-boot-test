package com.example.simplespringboottest.prac.message.rabbitmq.helloworld1;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.230.101");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");


        // 创建连接
        Connection  connection = factory.newConnection();
        // 创建通道
        Channel channel = connection.createChannel();
        // 通过通道声明交换机
        // 参数1：队列名称
        // 参数二：是否持久化
        // 参数三：是否独占队列
        // 参数四：是否在消费完成后自动删除队列
        // 参数五：其他参数
        channel.queueDeclare("dyhTestQueue", false, false, false, null);
        // 消费消息
        channel.basicConsume("dyhTestQueue", false, new Reciver(channel));

    }
}

class  Reciver extends DefaultConsumer {

    private Channel channel;
    //重写构造函数,Channel通道对象需要从外层传入，在handleDelivery中要用到
    public Reciver(Channel channel) {
        super(channel);
        this.channel = channel;
    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

        String message = new String(body);
        System.out.println("消费者接收到的消息："+message);
        System.out.println("消息的TagId："+envelope.getDeliveryTag());
        //false只确认签收当前的消息，设置为true的时候则代表签收该消费者所有未签收的消息
        channel.basicAck(envelope.getDeliveryTag(), false);
    }
}
