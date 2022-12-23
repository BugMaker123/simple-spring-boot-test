package com.example.simplespringboottest.prac.net.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) throws IOException {
        // 1.创建一个服务端socket，指定端口
        ServerSocket serverSocket = new ServerSocket(8080);
        // 2.调用accept()方法开始监听，等待客户端的连接
        Socket socket = serverSocket.accept();
        // 获取数据
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);

        String s = new String(bytes, 0, len);
        System.out.println(s);
        // 3.关闭资源
        socket.close();
        serverSocket.close();
    }
    public void receiveMsg() throws IOException {
        String result = "";
        // 1.创建一个服务端socket，指定端口
        ServerSocket serverSocket = new ServerSocket(8080);
        // 2.调用accept()方法开始监听，等待客户端的连接
        Socket socket = serverSocket.accept();
        // 获取数据
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);

        result = new String(bytes, 0, len);
        System.out.println(result);
        // 3.关闭资源
        socket.close();
        serverSocket.close();
    }
}
