package com.example.simplespringboottest.prac.design_pattern.factory.abstractFactory;

public abstract class AbstractFactory {

    public abstract ColorFactory getColor(String color);

    public abstract ShapeFactory getShape(String shape) ;
}
