package com.example.simplespringboottest.prac.design_pattern.factory.abstractFactory;

public class ColorFactory extends AbstractFactory {

    @Override
    public ColorFactory getColor(String color) {
        if (color == null) {
            return null;
        }
        if (color.equalsIgnoreCase("RED")) {
            return new Red();
        } else if (color.equalsIgnoreCase("GREEN")) {
            return new Green();
        } else if (color.equalsIgnoreCase("BLUE")) {
            return new Blue();
        }
        return null;
    }

    @Override
    public ShapeFactory getShape(String shape) {
        return null;
    }
}

