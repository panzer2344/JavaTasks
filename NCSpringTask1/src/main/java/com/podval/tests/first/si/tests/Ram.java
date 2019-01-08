package com.podval.tests.first.si.tests;

public class Ram {

    private String name = "ram0";

    public String getName() {
        System.out.println("using get for ram with name " + name);
        return name;
    }

    public void setName(String name) {
        System.out.println("using set for ram with name " + this.name + " and changing to name = " + name);
        this.name = name;
    }
}
