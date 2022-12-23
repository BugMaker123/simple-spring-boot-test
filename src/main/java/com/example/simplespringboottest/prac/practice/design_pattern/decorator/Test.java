package com.example.simplespringboottest.prac.practice.design_pattern.decorator;

/**
 * @ ClassName: Test
 * @Author: legen
 * @Date: 2020/12/10
 */
public class Test {
    public static void main(String[] args) {
        Water coffee = new RealDecorator(new Coffee());
        coffee.drink();
        Water tea = new RealDecorator(new Tea());
        tea.drink();
        System.out.println("装饰者模式,需要一个抽象装饰者,一个实际装饰者,起到的作用相当于增加对象的属性(接口的功能)" +
                "向杯子中加水,再加小苏打(此时接口增加小苏打的口感),再加糖,最后变成了苏打水(这时候发现变甜了),加上泡腾片,就变成了泡泡苏打水");
    }
}
