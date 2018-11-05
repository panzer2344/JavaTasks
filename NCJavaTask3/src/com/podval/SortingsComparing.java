package com.podval;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortingsComparing {

    private static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
            if (i > 1 && i % 20 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    private static void BubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    int tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    private static void SelectionSort(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            int min = array[i];
            int min_index = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[j] < min){
                    min = array[j];
                    min_index = j;
                }
            }
            if(array[i] > min){
                int tmp = array[i];
                array[i] = array[min_index];
                array[min_index] = tmp;
            }
        }
    }

    public static void test(boolean print, int size){
        int[] testArray = new int[size];
        int[] bubbleResult, selectionResult, arraySortResult;
        long startTime, estimatedTime;

        /*init*/
        System.out.print("testArray(Init): ");
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = (int) (Math.random() * 100);
        }
        System.out.println();

        /*print init array*/
        if(print) {
            printArray(testArray);
        }
        System.out.println();

        /*Bubble*/
        bubbleResult = testArray.clone();
        startTime = System.nanoTime();
        BubbleSort(bubbleResult);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Bubble: " + estimatedTime + "ns ");
        if(print) {
            printArray(bubbleResult);
        }

        /*Selection*/
        selectionResult = testArray.clone();
        startTime = System.nanoTime();
        SelectionSort(selectionResult);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Selection: " + estimatedTime + "ns ");
        if(print) {
            printArray(selectionResult);
        }

        /*Array.sort*/
        arraySortResult = testArray.clone();
        startTime = System.nanoTime();
        Arrays.sort(arraySortResult);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Arrays.sort: " + estimatedTime + "ns ");
        if(print) {
            printArray(arraySortResult);
        }
    }
}


