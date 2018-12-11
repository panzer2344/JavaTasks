package com.podval;

public class test {
    public static void main(String[] args) {
        InitClass a = new InitClass();
    }
}


class InitClass{
    private static int loop = 15 ;
    static final int INTERVAL = 10 ;
    boolean flag ;

    static { INTERVAL = 10; }
}
