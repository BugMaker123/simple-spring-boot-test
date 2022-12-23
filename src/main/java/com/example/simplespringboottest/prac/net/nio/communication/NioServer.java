package com.example.simplespringboottest.prac.net.nio.communication;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioServer {

    void createNioServer() {
        try {
            // 创建一个ServerSocketChannel对象
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(8888);
            serverSocketChannel.socket().bind(inetSocketAddress);
            //设置为非阻塞，否则会报 IllegalBlockingModeException 异常
            serverSocketChannel.configureBlocking(false);
            //创建选择器对象
            Selector selector = Selector.open();
            //将服务端通道注册到Selector
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {

                //Selector监听所有注册的通道，这里选择带超时的监听（这里是阻塞的），返回的是有事件触发的通道个数
                if (selector.select(5000) == 0) {
                    System.out.println("服务器等待5秒，没有连接");
                    continue;
                }
                //获取有事件触发的通道关联的 SelectionKey，然后通过 SelectionKey 反向获取 SocketChannel
                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                //遍历集合
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    //客户端请求连接事件
                    if (key.isAcceptable()) {
                        //注意这里的 accept() 虽然是阻塞的，但是因为已经明确了是连接事件，所以会立刻执行
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        System.out.println("客户端连接成功，生成SocketChannel=" + socketChannel.hashCode());
                        //设置为非阻塞
                        socketChannel.configureBlocking(false);
                        //将客户端通道注册到 Selector，并关联一个 buffer
                        socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    }
                    //读事件
                    else if (key.isReadable()) {
                        //通过 SelectionKey 反向获取 SocketChannel
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        //获取关联的 buffer
                        ByteBuffer buffer = (ByteBuffer) key.attachment();
                        //读取数据客户端发送的数据
                        socketChannel.read(buffer);
                        System.out.println("客户端发送数据：" + new String(buffer.array()));
                    }
                    //手动从集合中删除 SelectionKey，避免重复操作
                    iterator.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        NioServer nioServer = new NioServer();
        nioServer.createNioServer();
    }
}
