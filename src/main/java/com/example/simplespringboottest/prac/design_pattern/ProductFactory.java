package com.example.simplespringboottest.prac.design_pattern;

public class ProductFactory extends AbstractFactory {


    private ProductFactory() {

    }

    @Override
    public ProductFactory createProduct(String type) {
        if (type.equals("car")){
            return new ProductFactory();
        }
        return null;
    }
}
