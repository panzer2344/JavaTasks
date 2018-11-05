package com.podval;

import java.math.BigInteger;

public class FactorialComparing {

    private static long recursionFactorial(long n){
        if(n > 1){
            return n * recursionFactorial(n - 1);
        }
        else{
            return 1;
        }
    }

    private static long loopFactorial(long n){
        long result = n;
        for(long i = n - 1; i > 1; i--){
            result *= i;
        }
        return result;
    }

    private static BigInteger recursionFactorialBig(BigInteger n){
        if(n.compareTo(BigInteger.ONE) == 1){
            return n.multiply(recursionFactorialBig(n.subtract(BigInteger.ONE)));
        }
        else{
            return BigInteger.ONE;
        }
    }

    private static BigInteger loopFactorialBig(BigInteger n){
        BigInteger result = new BigInteger(n.toString());
        for(BigInteger i = n.subtract(BigInteger.ONE); i.compareTo(BigInteger.ONE) == 1; i = i.subtract(BigInteger.ONE)){
            result = result.multiply(i);
        }
        return result;
    }

    public static void test(long n){
        long startTime, estimatedTime;

        /*Big Values*/
        if(n > 20){
            BigInteger N = new BigInteger(String.valueOf(n));

            /*recursion*/
            System.out.print("recursion: ");
            startTime = System.currentTimeMillis();
            System.out.print(N + "! = " + recursionFactorialBig(N) + " ");
            estimatedTime = System.currentTimeMillis() - startTime;
            System.out.println(" by time = " + estimatedTime + "ms");

            /*loop*/
            System.out.print("loop: ");
            startTime = System.currentTimeMillis();
            System.out.print(N + "! = " + loopFactorialBig(N) + " ");
            estimatedTime = System.currentTimeMillis() - startTime;
            System.out.println(" by time = " + estimatedTime + "ms");
        }
        /*Small Values*/
        else {
            /*recursion*/
            System.out.print("recursion: ");
            startTime = System.nanoTime();
            System.out.print(n + "! = " + recursionFactorial(n) + " ");
            estimatedTime = System.nanoTime() - startTime;
            System.out.println(" by time = " + estimatedTime + "ns");

            /*loop*/
            System.out.print("loop: ");
            startTime = System.nanoTime();
            System.out.print(n + "! = " + loopFactorial(n) + " ");
            estimatedTime = System.nanoTime() - startTime;
            System.out.println(" by time = " + estimatedTime + "ns");
        }
    }
}
