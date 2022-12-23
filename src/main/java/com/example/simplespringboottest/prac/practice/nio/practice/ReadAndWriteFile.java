package com.example.simplespringboottest.prac.practice.nio.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * @ ClassName: ReadAndWriteFile
 * @Author: legen
 * @Date: 2021/6/10
 */
public class ReadAndWriteFile {
    //private Selector selector;

    public static void main(String[] args) throws IOException {
        writeFileBuffer();
        readFileBuffer();
    }

    private static void readFileBuffer() throws IOException {
        FileInputStream fis = new FileInputStream(new File("C:\\Users\\legen\\Desktop", "aaa.txt"));
        FileChannel channel = fis.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(100);
        while(channel.read(buffer)!=-1){
            buffer.clear();
            byte[] bytes = buffer.array();
            System.out.println(new String(bytes));
        }
    }

    private static void writeFileBuffer() throws IOException {
        File file = new File("C:\\Users\\legen\\Desktop", "aaa.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        FileChannel channel = fos.getChannel();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ByteBuffer byteBuffer = Charset.forName("UTF-8").encode(str);
        channel.write(byteBuffer);
        int length = 0;
        while ((channel.write(byteBuffer))!=0){
            System.out.println("写入长度:" + length);
        }
    }
}
