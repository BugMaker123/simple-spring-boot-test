package com.example.simplespringboottest.prac.practice.others;

import lombok.Data;

/**
 * @ ClassName: Cat
 * @Author: legen
 * @ate: 2021/4/8
 */
@Data
public class Cats extends Animals{
    @Override
    public void getAnswer(){
        super.getAnswer();
        System.out.println("this is child");
    }
    public static void main(String[] args) {
        Cats cat = new Cats();
        cat.getAnswer();
        Animals cat2 = new Cats();
        cat2.getAnswer();
        Animals animals = new Animals();
        animals.getAnswer();

    }
}

