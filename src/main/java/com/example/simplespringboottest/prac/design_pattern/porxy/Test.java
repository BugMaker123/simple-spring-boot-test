package com.example.simplespringboottest.prac.design_pattern.porxy;

public class Test {
    public static void main(String[] args) {
        Image image = new ColorImage(new NoColorImage());
        // 图像将从磁盘加载
        image.display();
        System.out.println("");
        // 图像不需要从磁盘加载
        image.display();
    }
}
