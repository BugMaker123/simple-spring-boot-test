package com.example.simplespringboottest.prac.first.base;

public class Children extends Parent{
    public Children() {
        System.out.println("Children none args constructor");
    }

    public Children(String name, int age, String profession) {
        super(name, age, profession);
    }
}


class Test{
    public static void main(String[] args) {
        Parent parent = new Children();
        parent.setAge(10);
        System.out.println("==================");
        Children children = new Children();
        //children.setAge(10);
    }
}
