package com.example.simplespringboottest.prac.practice.nio.simple;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @ ClassName: SimpleNioReadAndWriteFile
 * @Author: legen
 * @Date: 2021/6/9
 */
public class SimpleNioReadAndWriteFile {
    public static void main(String[] args) throws IOException {
        writeFile();
        readFile();
    }
    public static void writeFile() throws IOException {
        File file = new File("C:\\Users\\legen\\Desktop", "NIOWriteContent.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        FileChannel channel = fos.getChannel();
        ByteBuffer buffer = Charset.forName("utf8").encode("金麟岂是池中物，一遇风云便化龙");
        // 字节缓冲的容量和limit会随着数据长度变化，不是固定不变的
        System.out.println("初始化容量和limit：" + buffer.capacity() + "," + buffer.limit());
        int length = 0;
        while ((length = channel.write(buffer)) != 0) {
            /*
             * 注意，这里不需要clear，将缓冲中的数据写入到通道中后 第二次接着上一次的顺序往下读
             */
            System.out.println("写入长度:" + length);
        }
        buffer.clear();
        channel.close();
        fos.close();
    }

    public static void readFile() throws IOException {
        FileInputStream fis = new FileInputStream(new File("C:\\Users\\legen\\Desktop", "工作文件.txt"));
        FileChannel channel = fis.getChannel();
        // 容量，表示的是每个byteBuffer对象的容量，容量越小，每次读取到的数据越少
        int capacity=1000;
        ByteBuffer bf = ByteBuffer.allocate(capacity);
        channel.read(bf);
        System.out.println("限制是：" + bf.limit() + ",容量是：" + bf.capacity() + " ,位置是：" + bf.position());
        int length=-1;
        while ((length=channel.read(bf))!=-1){
            // 不clear，此循环将一直进行
            bf.clear();
            byte[] bytes = bf.array();
            System.out.println(new String(bytes)+"\n");
        }
        bf.clear();
        //最后把管道关闭
        channel.close();
        fis.close();
    }
}
