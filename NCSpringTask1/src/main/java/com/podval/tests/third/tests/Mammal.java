package com.podval.tests.third.tests;

public abstract class Mammal implements Animal {
    private String paws;

    public Mammal(){
        System.out.println("creating mammal");
        this.paws = "normal paws";
    }

    public String getPaws() {
        System.out.println("Using get for mammal");
        return paws;
    }

    public void setPaws(String paws) {
        System.out.println("Using set for mammal");
        this.paws = paws;
    }

    public Mammal(String paws){
        System.out.println("Creating mammal");
        this.paws = paws;
    }
}
