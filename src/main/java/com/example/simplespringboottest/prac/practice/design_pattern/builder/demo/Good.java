package com.example.simplespringboottest.prac.practice.design_pattern.builder.demo;

/**
 * @ ClassName: Good
 * @Author: legen
 * @Date: 2020/12/15
 */
public class Good {
    private String name;
    private String price;
    private String type;

    public Good() {
    }

    public Good(String name, String price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
