package com.example.simplespringboottest.prac.design_pattern.factory.abstractFactory;

public class ShapeFactory extends AbstractFactory {

    @Override
    public ColorFactory getColor(String color) {
        return null;
    }

    @Override
    public ShapeFactory getShape(String shape) {
        if (shape == null) {
            return null;
        }
        if (shape.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shape.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shape.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}
