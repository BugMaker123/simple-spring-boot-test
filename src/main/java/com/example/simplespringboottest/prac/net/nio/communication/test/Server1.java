package com.example.simplespringboottest.prac.net.nio.communication.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

public class Server1 {
    public static void main(String[] args) {
        new Server1().createNioServer();
    }

    private void createNioServer() {
        try {
            // 1.创建一个 ServerSocketChannel
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // 2.绑定一个端口
            serverSocketChannel.bind(new InetSocketAddress(9090));
            // 3.设置为非阻塞
            serverSocketChannel.configureBlocking(false);
            // 4.获取一个 Selector
            Selector selector = Selector.open();
            // 5.将 ServerSocketChannel 注册到 Selector 上
            serverSocketChannel.register(selector, 0, null);
            // 6.循环等待新接入的连接
            while(true){
                // 7.阻塞等待需要处理的事件发生
                selector.select();
                // 8.获取所有接入事件的 SelectionKey 实例
                Iterator<SelectionKey> selectionKeyIterator = selector.selectedKeys().iterator();
                // 9.根据 SelectionKey 的操作类型，调用对应的 Handler 处理器进行处理
                while(selectionKeyIterator.hasNext()){
                    // 10.获取 SelectionKey 实例
                    SelectionKey selectionKey = selectionKeyIterator.next();
                    // 11.移除 SelectionKey 实例
                    selectionKeyIterator.remove();
                    // 12.根据 SelectionKey 的操作类型，调用对应的 Handler 处理器进行处理
                    if(selectionKey.isAcceptable()) {
                        // 13.获取客户端连接
                        ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                        // 14.接受客户端连接
                        server.accept();
                        // 14.设置客户端为非阻塞
                        server.configureBlocking(false);
                        // 15.将客户端连接注册到 Selector 上
                        server.register(selector, SelectionKey.OP_READ);
                    } else if(selectionKey.isReadable()) {
                        // 16.读取数据
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

