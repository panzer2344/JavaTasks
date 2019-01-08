package com.podval.tests.fifth.tests;

public class PC implements IComputer {

    private Hdd hdd;

    public PC(){
        super();
    }

    public PC(Hdd hdd){
        System.out.println("Using constructor in pc class");
        this.hdd = hdd;
    }

    public Hdd getHdd() {
        System.out.println("using get for pc");
        return hdd;
    }

    public void setHdd(Hdd hdd) {
        System.out.println("using set for pc with new hdd with name = " + hdd.getName());
        this.hdd = hdd;
    }

    public void copyFromDvd() {
        System.out.println("Copy to pc hdd");
    }
}
