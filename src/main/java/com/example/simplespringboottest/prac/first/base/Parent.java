package com.example.simplespringboottest.prac.first.base;


public class Parent {
    private String name;
    private int age;
    private String profession;

    public Parent() {
        System.out.println("Parent none args constructor");
    }

    public Parent(String name, int age, String profession) {
        this.name = name;
        this.age = age;
        this.profession = profession;
        System.out.println("Parent all args constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
