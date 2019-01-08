package com.podval.tests.third.tests;

public class Lion extends Cat {
    private String mane;

    public Lion(){
        super();
        System.out.println("creating lion");
        this.mane = "normal mane";
    }

    public String getMane() {
        System.out.println("Using get for lion");
        return mane;
    }

    public void setMane(String mane) {
        System.out.println("Using set for lion");
        this.mane = mane;
    }

    @Override
    public void voice() {
        System.out.println("Lion with " + getPaws() + " and " + getTail() + " and " + getMane() + " makes a Royal roar");
    }
}
