package com.podval.tests.first.ci.tests;

public class DvdRom {

    private String name = "dvdRom0";

    public DvdRom(){
        System.out.println("base constructor for dvdRom with name " + name);
    }

    public DvdRom(String name){
        this.name = name;
        System.out.println("init constructor for dvdRom with name " + name);
    }
}
