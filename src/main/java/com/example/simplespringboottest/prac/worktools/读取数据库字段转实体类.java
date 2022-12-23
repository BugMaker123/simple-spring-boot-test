package com.example.simplespringboottest.prac.worktools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ ClassName: 读取数据库字段转实体类
 * @Author: legen
 * @Date: 2021/1/12
 */
public class 读取数据库字段转实体类 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\legen\\Desktop\\new 6.txt";
        File file = new File(path);
        FileInputStream inputStream = new FileInputStream(file);
        int len = 0;
        byte[] bytes =new byte[1024];
        List<String>finalStrList = new ArrayList<>();
        while ((len=inputStream.read(bytes))!=-1){
            List<String>chList = new ArrayList<>();
            String str = new String(bytes,0,len);
            char[] chars = str.toCharArray();
            String zeroStr = "";
            for (int i = 0; i < chars.length; i++) {
                if (chars[i]=='\r' || chars[i]=='\n'){
                    continue;
                }

                if (chars[i]=='_'){
                    chars[i+1]= (char) (chars[i+1]-32);
                    continue;
                }
                zeroStr = zeroStr+chars[i];
                chList.add(String.valueOf(chars[i]));
                if (chars[i]==','){
                    finalStrList.add(zeroStr);
                    continue;
                }
            }

        }
        for (int i = 0; i < finalStrList.size(); i++) {
            System.out.println(finalStrList.get(i));
        }
    }
}
