package com.example.simplespringboottest.prac.practice.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ ClassName: Server
 * @Author: legen
 * @Date: 2021/2/1
 */
public class Server {
    public static void consumeMessage() throws IOException {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        try {
            serverSocket = new ServerSocket(8051);
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            // todo 此时是否可以直接读取?
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String s = bufferedReader.readLine();
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
            socket.close();
            serverSocket.close();
        }

    }
}
