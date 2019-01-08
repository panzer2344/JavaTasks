package com.podval.tests.first.si.tests;

public class DvdRom {

    private String name = "dvdRom0";

    public String getName() {
        System.out.println("using get for dvdRom with name " + name);
        return name;
    }

    public void setName(String name) {
        System.out.println("using set for dvdRom with name " + this.name + " and changing to name = " + name);
        this.name = name;
    }
}
