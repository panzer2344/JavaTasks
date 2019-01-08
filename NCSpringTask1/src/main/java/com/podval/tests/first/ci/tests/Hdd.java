package com.podval.tests.first.ci.tests;

public class Hdd {

    private String name = "hdd0";

    public Hdd(){
        System.out.println("base constructor for hdd with name " + name);
    }

    public Hdd(String name){
        this.name = name;
        System.out.println("init constructor for hdd with name " + name);
    }
}
