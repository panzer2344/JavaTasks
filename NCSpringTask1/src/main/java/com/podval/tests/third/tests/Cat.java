package com.podval.tests.third.tests;

public class Cat extends Mammal {
    private String tail;

    public Cat(){
        super();
        System.out.println("creating cat");
        this.tail = "normal tail";
    }

    public String getTail() {
        System.out.println("Using get for cat");
        return tail;
    }

    public void setTail(String tail) {
        System.out.println("Using set for cat");
        this.tail = tail;
    }

    public void voice() {
        System.out.println("The cat's meow!");
    }
}
