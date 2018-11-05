package com.podval.Tests;


import com.podval.*;

public class tests {
    public static void main(String[] args) {
        /* sortings */
        System.out.println("Sortings");
        SortingsComparing.test(false, 10000);

        System.out.println();
        System.out.println();

        /* factorials */
        System.out.println("Factorials: \n");
        FactorialComparing.test(20);
        FactorialComparing.test(19);
        FactorialComparing.test(21);
        FactorialComparing.test(500);

        System.out.println();
        System.out.println();

        /* Inner loops */
        InnerLoops.test(10, 7);

        /* Problems on one-dimensional arrays */
        OneDimArraysProblems.test();

        /* Problems on multi-dimensional arrays */
        MultyDimArraysProblems.test();

        /* Control Structures*/
        ControlStructures.test();
    }
}
