package com.podval.tests.fifth.tests;

public class Hdd {

    private String name = "hdd0";

    public String getName() {
        System.out.println("Using get for hdd");
        return name;
    }

    public void setName(String name) {
        System.out.println("using set for hdd with new name = " + name );
        this.name = name;
    }
}
