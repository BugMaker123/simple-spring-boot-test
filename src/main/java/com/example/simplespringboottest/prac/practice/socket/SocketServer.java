package com.example.simplespringboottest.prac.practice.socket;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;

/**
 * @ ClassName: SocketServer
 * @Author: legen
 * @Date: 2021/4/8
 */
public class SocketServer {
    static String host="127.0.0.1";
    static Integer port = 9052;

    public static void getMsg() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        serverSocket.accept();
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(new File("")));

    }
}
