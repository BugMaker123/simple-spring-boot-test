package com.example.simplespringboottest.prac.worktools;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @ ClassName: FileReader
 * @Author: legen
 * @Date: 2021/1/18
 */
public class FileReaderTest {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\legen\\Desktop\\new 6.txt");
        FileReader fr = new FileReader(file);
        char[] chars = new char[1024];
        fr.read(chars);
        for (int i = chars.length-1; i >0 ; i--) {
            System.out.print(chars[i]);
        }

        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
    }
}
