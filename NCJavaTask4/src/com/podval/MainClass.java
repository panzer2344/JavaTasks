package com.podval;

import com.podval.MyLinkedList;

import java.util.LinkedList;

public class MainClass {

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        final int initSize = 10;

        for(int i = 0; i < 10; i++){
            Integer tmp = Integer.valueOf((int)(Math.random() * 100));
            System.out.println(tmp);
            list.add(tmp);
        }
        System.out.println(list);

        list.add(Integer.valueOf(10));
        System.out.println(list);

        for(int i = 0; i < initSize / 2 + 1; i++){
            list.remove(0);
        }
        System.out.println(list);

        list.add(5, Integer.valueOf(13));
        System.out.println(list);

        list.set(3, Integer.valueOf(17));
        System.out.println(list);

        System.out.println(list.get(2));
        System.out.println(list);

        for (Integer i : list) {
            System.out.println(i);
        }

        System.out.println(list);

        MyLinkedList<Integer> myCompList = new MyLinkedList<>(); // for comparing with java.util.LinkedList
        LinkedList<Integer> juCompList = new LinkedList<>();
        int compListSize = 10000;
        long startTime = 0, estimatedTime = 0;
        Integer[] values = new Integer[compListSize];

        /* init array */
        for(int i = 0; i < compListSize; i++){
            values[i] = Integer.valueOf((int)(Math.random() * 100));
        }

        /* adding */

        /* myList */
        startTime = System.nanoTime();
        for(int i = 0; i < compListSize; i++){
            myCompList.add(values[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("add to myList: " + estimatedTime);

        /* ju List */
        startTime = System.nanoTime();
        for(int i = 0; i < compListSize; i++){
            juCompList.add(values[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("add to juList: " + estimatedTime);

        /* search */

        /* myList */
        startTime = System.nanoTime();
        for(int i = compListSize - 1; i > 0; i--){
            myCompList.indexOf(values[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("search in myList: " + estimatedTime);

        /* ju List */
        startTime = System.nanoTime();
        for(int i = compListSize - 1; i > 0; i--){
            juCompList.indexOf(values[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("search in juList: " + estimatedTime);

        /* removing */

        /* myList */
        startTime = System.nanoTime();
        for(int i = compListSize - 1; i > 0; i--){
            myCompList.remove(i);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("removing from myList: " + estimatedTime);

        /* ju List */
        startTime = System.nanoTime();
        for(int i = compListSize - 1; i > 0; i--){
            juCompList.remove(i);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("removing from juList: " + estimatedTime);

    }
}
