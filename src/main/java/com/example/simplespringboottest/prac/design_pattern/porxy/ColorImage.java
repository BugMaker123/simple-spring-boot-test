package com.example.simplespringboottest.prac.design_pattern.porxy;

public class ColorImage implements Image {
    private NoColorImage noColorImage;

    public ColorImage(NoColorImage noColorImage) {
        this.noColorImage = noColorImage;
    }

    @Override
    public void display() {
        System.out.println("ColorImage");
    }

}
