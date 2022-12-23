package com.example.simplespringboottest.prac.net.nio;

import io.netty.channel.ChannelFuture;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

/**
 * NIO的channel类似于BIO的stream，但是区别是：
 * channel既可以从buffer中读，也可以向buffer中写，是双向的，而stream是单向的
 * channel可以实现异步读写，而stream是阻塞的
 * 常用的Channel类：FileChannel（文件读写）、DatagramChannel（UDP协议）、ServerSocketChannel和SocketChannel（TCP协议）
 */
public class SimpleChannelTest {
    public static void main(String[] args) throws IOException {
        readFile();
        writeFile();
    }

    static void readFile() throws IOException {
        FileInputStream fileInputStream = null;
        try {
            File file = new File("D:\\ab.txt");
            fileInputStream = new FileInputStream(file);
            FileChannel fileChannel = fileInputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
            fileChannel.read(byteBuffer);
            System.out.println(new String(byteBuffer.array()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fileInputStream.close();
        }
    }

    static void writeFile() throws IOException {
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File("D:\\abc.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            FileChannel fileChannel = fileOutputStream.getChannel();
            // 为buffer区域分配空间
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put("To be or not to be,that is a question".getBytes());
            // warning！！！ 读写切换，不切换会无法继续走
            byteBuffer.flip();
            fileChannel.write(byteBuffer);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            fileOutputStream.close();
        }
    }

    private static void copyFile() {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream("/Users/jijingyi/Desktop/test.txt");
            FileChannel fileChannel01 = inputStream.getChannel();

            outputStream = new FileOutputStream("test.txt");
            FileChannel fileChannel02 = outputStream.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(5);

            while (true) {
                //如果文件读完返回-1
                int read = fileChannel01.read(byteBuffer);
                if (read == -1) {
                    break;
                }
                //读写反转
                byteBuffer.flip();
                fileChannel02.write(byteBuffer);
                //这里写完要重置channel，否则会由于position=limit出现死循环（因为再次读取时read会一直等于0）
                byteBuffer.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用transfFrom实现文件拷贝
     */
    private static void copyFileByTransf(){
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream("/Users/jijingyi/Desktop/17岁.mp3");
            FileChannel channelSrc = inputStream.getChannel();

            outputStream = new FileOutputStream("/Users/jijingyi/Desktop/100岁.mp3");
            FileChannel channelDest = outputStream.getChannel();

            channelDest.transferFrom(channelSrc,0,channelSrc.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null){
                    inputStream.close();
                }
                if (outputStream != null){
                    outputStream.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
