package com.example.simplespringboottest.prac.design_pattern;

public enum ProductEnum {
    CAR("car", "car","car"),
    ENGINE("engine","engine","engine");

    private String name;

    private String desc;

    private String type;




    ProductEnum(String name, String desc, String type) {
        this.name = name;
        this.desc = desc;
        this.type = type;
    }
}
