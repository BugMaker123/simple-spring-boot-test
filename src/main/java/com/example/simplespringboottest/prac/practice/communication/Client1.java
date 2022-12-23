package com.example.simplespringboottest.prac.practice.communication;


import java.io.*;
import java.net.Socket;

/**
 * @ ClassName: Client1
 * @Author: legen
 * @Date: 2021/2/1
 */
public class Client1 {
    public static void sendMsg() throws IOException {
        Socket socket = new Socket("127.0.0.1",8066);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("测试客户端和服务器通信，服务器接收到消息返回到客户端\n");
        bw.flush();

        //读取服务器返回的消息
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String mess = br.readLine();
        System.out.println("服务器："+mess);
    }
}
 class Test{
     public static void main(String[] args) throws IOException {
         Server.consumeMessage();
         Client1.sendMsg();
     }
 }