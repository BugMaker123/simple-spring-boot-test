package com.example.simplespringboottest.prac.net.nio.communication;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NioClient {
    void createNioClient(){
        try {
            //创建一个 SocketChannel
            SocketChannel socketChannel = SocketChannel.open();
            //设置为非阻塞
            socketChannel.configureBlocking(false);
            //提供服务端 ip和port，并连接服务端
            InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1",8888);
            socketChannel.connect(inetSocketAddress);

            //这里是非阻塞的，如果还没有连接成功，可以处理其他业务
            if (!socketChannel.isConnected()){
                while (!socketChannel.finishConnect()){
                    System.out.println("客户端还未完成连接，处理其他业务");
                }
            }

            //向服务端发送数据
            String data = "哈哈哈";
            ByteBuffer byteBuffer = ByteBuffer.wrap(data.getBytes());
            socketChannel.write(byteBuffer);
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new NioClient().createNioClient();
    }
}
