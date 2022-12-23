package com.example.simplespringboottest.prac.message.rabbitmq;

public class Test {
    public static void main(String[] args) {
        new Thread(()->{
            new Dt().test();
        }).start();
    }
}

class Dt{
    private String name;
    private String age;

    public Dt() {

    }
    public Dt(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void test(){
        System.out.println("test");
    }
}