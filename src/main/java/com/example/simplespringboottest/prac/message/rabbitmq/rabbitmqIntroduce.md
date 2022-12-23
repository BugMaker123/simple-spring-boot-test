rabbitmq具体有那些属性
生产者 producer
消费者 consumer
队列 queue
交换机 exchange
路由键 routingKey
绑定 binding
消息 message
通道 channel
连接 connection
事务 transaction
确认 confirm
消息持久化 message durable
消息可靠性 message reliable
消息可恢复性 message recoverable
消息可追踪性 message traceable

rabbitmq的工作模式有五种

1.简单模式
   生产者发生helloword，消费者进行消费
   一个生产者，一个消费者，一个队列，生产者发送消息，消费者接收消息（不需要使用交换机，使用默认的交换机）
    1.1 生产者具体工作过程
    `   ConnectionFactory factory = new ConnectionFactory();
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
        }`
    1.2.消费者具体工作过程
        `ConnectionFactory factory = new ConnectionFactory();
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
        channel.basicConsume("dyhTestQueue", false, new Reciver(channel));`


2. 工作模式
    一个生产者，多个消费者，一个队列，生产者发送消息，消费者接收消息（不需要使用交换机，使用默认的交换机）
    多个消费者，轮询的方式消费消息。一个消费者消费完消息后，另一个消费者才能消费消息。
    

3. 发布订阅模式，
   一个生产者，多个消费者，一个交换机，多个队列，生产者发送消息，消费者接收消息（需要使用交换机，使用默认的交换机）
交换机可以细分为3种 
    fanout类型的交换机，会把消息发送给所有绑定的队列（广播模式）
    direct类型的交换机，会把消息发送给routingKey和绑定的队列相同的队列
    topic类型的交换机，会把消息发送给routingKey和绑定的队列相匹配的队列（）



rabbitmq提供了一个监听器（confirmListener）去监听broker（队列与交换机）是否收到消息，有confirm与return两种状态，
confirm是指消息是否到达交换机，return是指消息是否到达队列，
如果消息没有到达队列，会触发return监听器，如果消息没有到达交换机，会触发confirm监听器。
如果消息到达交换机，但是没有到达队列，会触发return监听器，如果消息到达交换机，也到达队列，不会触发任何监听器。

而消费者确认是在 消费者消费消息后，告诉broker（队列与交换机）消息已经被消费了，broker（队列与交换机）会删除消息。
具体是通过 basicAck方法实现的，basicAck方法有两个参数，第一个参数是消息的标识，第二个参数是是否批量确认。
basicAck为true时，表示确认消息，broker（队列与交换机）会删除消息，为false时，表示不确认消息，broker（队列与交换机）不会删除消息。

    