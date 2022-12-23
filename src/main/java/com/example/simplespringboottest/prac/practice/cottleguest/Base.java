package com.example.simplespringboottest.prac.practice.cottleguest;

/**
 * @ ClassName: Base
 * @Author: legen
 * @Date: 2021/5/25
 */

public class Base{
    public Base(String s){
        System.out.print("B");
    }
}
 class Derived extends Base{
    public Derived (String s) {
        super(s);
        System.out.print("D");
    }
    public static void main(String[] args){
        new Derived("C");
    }
}