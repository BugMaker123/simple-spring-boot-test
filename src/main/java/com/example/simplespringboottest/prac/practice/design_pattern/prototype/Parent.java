package com.example.simplespringboottest.prac.practice.design_pattern.prototype;

/**
 * @ ClassName: Parent
 * @Author: legen
 * @Date: 2020/12/16
 */
public abstract class Parent implements Cloneable{
    protected String name;
    protected String age;
    protected String profession;

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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }
    abstract void eat();

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
