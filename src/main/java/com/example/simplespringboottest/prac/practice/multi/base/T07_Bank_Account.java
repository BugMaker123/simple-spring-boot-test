package com.example.simplespringboottest.prac.practice.multi.base;

/**
 * @ ClassName: T07_Bank_Account
 * @Author: legen
 * @Date: 2021/3/15
 */
public class T07_Bank_Account {
    private String name;
    private double price;

    public T07_Bank_Account(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public synchronized void setPrice(double price) {
        this.price = price;
        price =100.00;
    }

    public static void main(String[] args) {

    }
}
