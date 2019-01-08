package com.podval.tests.first.ci.tests;

public class Ram {

    private String name = "ram0";

    public Ram(){
        System.out.println("base constructor for ram with name " + name);
    }

    public Ram(String name){
        this.name = name;
        System.out.println("init constructor for ram with name " + name);
    }
}
