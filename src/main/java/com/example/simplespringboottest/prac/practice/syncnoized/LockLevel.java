package com.example.simplespringboottest.prac.practice.syncnoized;


import com.example.simplespringboottest.prac.practice.spi.Animal;
import org.openjdk.jol.info.ClassLayout;

/**
 * @ ClassName: LockLevel
 * @Author: legen
 * @Date: 2021/6/10
 */
public class LockLevel {
    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance(Animal.class).toPrintable());
    }
}
