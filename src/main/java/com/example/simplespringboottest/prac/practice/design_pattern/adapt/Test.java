package com.example.simplespringboottest.prac.practice.design_pattern.adapt;

/**
 * @ ClassName: Test
 * @Author: legen
 * @Date: 2020/12/10
 */
public class Test {
    public static void main(String[] args) {
        HumanService service = new WomanServiceImpl();
        service.eatFood();
        System.out.println("调用的method不一定是看到的method,结果另有出处");
    }
}
