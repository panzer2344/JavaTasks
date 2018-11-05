package com.podval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MultyDimArraysProblems {

    private static int[][] generateArray(int rows, int cols, int min, int max){
        int[][] array = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                array[i][j] = min + (int)(Math.random() * (max - min + 1));
            }
        }
        return array;
    }

    private static void printArray(int[][] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void test(){
        /* a. */
        /* Sum diagonal elements of 2-dim array */
        final int ROWS_A = 8, COLS_A = 8;
        final int MAX_A = 99, MIN_A = 1;

        int[][] arrayA = generateArray(ROWS_A, COLS_A, MIN_A, MAX_A);
        long sumMain = 0, sumSide = 0,
                prodMain = 1, prodSide = 1;

        printArray(arrayA);
        System.out.println();
        System.out.println();

        for(int i = 0; i < ROWS_A; i++){
            sumMain += arrayA[i][i];
            prodMain *= arrayA[i][i];

            sumSide += arrayA[i][COLS_A - i - 1];
            prodSide *= arrayA[i][COLS_A - i - 1];
        }

        System.out.println("sum of main elms: " + sumMain);
        System.out.println("prod of main elms: " + prodMain);
        System.out.println("sum of side elms: " + sumSide);
        System.out.println("prod of side elms: " + prodSide);

        System.out.println();
        System.out.println();


        /* b. */
        /* max elem and its index*/
        final int ROWS_B = 8, COLS_B = 5;
        final int MIN_B = -99, MAX_B = 99;

        class MaxIndex{
            public int max_index_row;
            public int max_index_col;

            MaxIndex(int row, int col){
                max_index_row = row;
                max_index_col = col;
            }
        }

        ArrayList max_indexes = new ArrayList();
        max_indexes.add(new MaxIndex(0, 0));

        int[][] arrayB = generateArray(ROWS_B, COLS_B, MIN_B, MAX_B);
        printArray(arrayB);

        for(int i = 0; i < ROWS_B; i++){
            for(int j = 0; j < COLS_B; j++){
                MaxIndex index = (MaxIndex) max_indexes.get(0);
                if(arrayB[i][j] > arrayB[index.max_index_row][index.max_index_col]){
                    max_indexes.clear();
                    max_indexes.add(new MaxIndex(i, j));
                }else if(arrayB[i][j] == arrayB[index.max_index_row][index.max_index_col]){
                    max_indexes.add(new MaxIndex(i, j));
                }
            }
        }

        System.out.println();

        MaxIndex index = (MaxIndex)max_indexes.get(0);
        System.out.println("max value = " + arrayB[index.max_index_row][index.max_index_col]);

        System.out.print("indexes: ");
        for(Object ind : max_indexes){
            MaxIndex indexi = (MaxIndex) ind;
            System.out.print("{" + indexi.max_index_row + "," + indexi.max_index_col + "} ");
        }

        System.out.println();
        System.out.println();
        System.out.println();

        /* c. */
        /* row with max prod */
        final int ROWS_C = 8, COLS_C = 5;
        final int MIN_C = -10, MAX_C = 10;

        long max_prod = -(long)Math.pow(MAX_C, ROWS_C);
        int max_prod_index = 0;

        int[][] arrayC = generateArray(ROWS_C, COLS_C, MIN_C, MAX_C);
        printArray(arrayC);

        for(int i = 0; i < ROWS_C; i++){
            long prod = 1;
            for (int j = 0; j < COLS_C; j++){
                prod *= arrayC[i][j];
            }
            if(Math.abs(prod) > max_prod){
                max_prod = prod;
                max_prod_index = i;
            }
        }
        System.out.println();

        System.out.println("index of row with max prod: " + max_prod_index);

        System.out.println();
        System.out.println();
        System.out.println();


        /* d. */
        /* sorts */
        final int ROWS_D = 10, COLS_D = 7;
        final int MIN_D = 0, MAX_D = 100;

        int[][] arrayD = generateArray(ROWS_D, COLS_D, MIN_D, MAX_D);
        printArray(arrayD);

        System.out.println();
        System.out.println();

        for(int row = 0; row < ROWS_D; row++){
            Arrays.sort(arrayD[row]);
            int[] tmp = arrayD[row].clone();
            for(int i = 0; i < COLS_D; i++){
                arrayD[row][i] = tmp[COLS_D - i - 1];
            }
        }

        printArray(arrayD);

        System.out.println();
        System.out.println();
        System.out.println();

    }

}
