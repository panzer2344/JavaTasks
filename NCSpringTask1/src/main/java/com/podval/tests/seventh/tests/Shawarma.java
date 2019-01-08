package com.podval.tests.seventh.tests;

public class Shawarma {

    private boolean isSpicy;

    public Shawarma(){}

    public void setIsSpicy(Boolean isSpicy) {
        System.out.println("using set for shawarma");
        this.isSpicy = isSpicy;
    }

    @Override
    public String toString() {
        return "This is " +
                (this.isSpicy ? " sharp " : " ") +
                "shawarma";
    }
}
