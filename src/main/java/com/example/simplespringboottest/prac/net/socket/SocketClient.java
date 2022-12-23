package com.example.simplespringboottest.prac.net.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import static java.lang.Thread.sleep;

public class SocketClient {

    public static void main(String[] args) throws IOException {
        // 创建一个客户端Socket对象
        Socket s = new Socket("127.0.0.1", 8080);
        //获取输出流，输出数据
        OutputStream outputStream = s.getOutputStream();
        outputStream.write("hello communication".getBytes());
        // 释放资源
        s.close();
    }

    public void sentMsg(String str) throws IOException, InterruptedException {
        // 创建一个客户端Socket对象
        Socket s = new Socket("127.0.0.1", 8080);
        sleep(2000);
        //获取输出流，输出数据
        OutputStream outputStream = s.getOutputStream();
        outputStream.write(str.getBytes());
        // 释放资源
        s.close();
    }
}
