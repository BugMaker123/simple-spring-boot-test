package com.example.simplespringboottest.prac.practice.nio.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioClient {

    private Selector selector;

    public static void main(String[] args) throws IOException {
        NioClient nioClient = new NioClient();
        nioClient.initClient();
        String msg = "hello nio";
        nioClient.sendMessage(msg);
    }

    private void sendMessage(String msg) throws IOException {
        while (true){
            selector.select();
            Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
            while(iterator.hasNext()){
                SocketChannel socketChannel = SocketChannel.open();
                socketChannel.connect(new InetSocketAddress("127.0.0.1",9090));
                socketChannel.configureBlocking(false);
                socketChannel.register(this.selector,SelectionKey.OP_ACCEPT);
                ByteBuffer buffer = ByteBuffer.wrap("HelloServer".getBytes());
                socketChannel.write(buffer);
            }
        }

    }

    private void initClient() throws IOException {
        // 客户端先获取一个通道
        SocketChannel socketChannel = SocketChannel.open();
        // 设置通道为非阻塞
        socketChannel.configureBlocking(false);
        // 生成一个selector，将通道绑定到选择器上
        this.selector = Selector.open();
        // 客户端连接服务器,需要在listen（）方法中调用channel.finishConnect() 才能完成连接
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 9090));
        //将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_CONNECT事件。
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
    }
}
