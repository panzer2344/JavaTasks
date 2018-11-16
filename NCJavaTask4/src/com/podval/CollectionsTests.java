package com.podval;

import java.util.*;

public class CollectionsTests {
    private static final int collectionSize = 10000;
    private static Integer[] values = new Integer[collectionSize];
    private static long startTime = 0, estimatedTime = 0;

    private static void newLine(){
        System.out.println();
        System.out.println();
    }

    private static void printEstTime(Collection<?> collection, long start){
        estimatedTime = System.nanoTime() - startTime;
        System.out.println(collection.getClass().toString() + ": " + estimatedTime);
    }

    private static void printEstTime(Map<?, ?> map, long start){
        estimatedTime = System.nanoTime() - startTime;
        System.out.println(map.getClass().toString() + ": " + estimatedTime);
    }

    private static <T> void add(T[] initArray, Collection<T>... collections){

        System.out.println("Adding: ");

        for(Collection<T> collection : collections){
            startTime = System.nanoTime();
            for(int i = 0; i < collectionSize; i++){
                collection.add(initArray[i]);
            }
            printEstTime(collection, startTime);
        }
        newLine();
    }

    private static <T> void searche(T[] initArray, List<T>... lists){

        System.out.println("Searching: ");

        for(List<T> list : lists) {
            startTime = System.nanoTime();
            for (int i = 0; i < collectionSize; i++) {
                list.indexOf(initArray[i]);
            }
            printEstTime(list, startTime);
        }
        newLine();

    }

    private static <T> void remove(T[] initArray, Collection<T>... collections){

        System.out.println("Removing: ");

        for(Collection<T> collection : collections){
            startTime = System.nanoTime();
            for(int i = 0; i < collectionSize; i++){
                collection.remove(initArray[i]);
            }
            printEstTime(collection, startTime);
        }
        newLine();
    }

    private static <T> void contains(T[] initArray, Collection<T>... collections){

        System.out.println("Searching: ");

        for(Collection<T> collection : collections){
            startTime = System.nanoTime();
            for(int i = 0; i < collectionSize; i++){
                collection.contains(initArray[i]);
            }
            printEstTime(collection, startTime);
        }
        newLine();
    }

    private static <T, K> void put(T[] initArray, K initValue, Map<T, K>... maps){

        System.out.println("Adding: ");

        for(Map<T, K> map : maps){
            startTime = System.nanoTime();
            for(int i = 0; i < collectionSize; i++){
                map.put(initArray[i], initValue);
            }
            printEstTime(map, startTime);
        }
        newLine();
    }

    private static <T, K> void contains(T[] initArray, Map<T, K>... maps){

        System.out.println("Searching: ");

        for(Map<T, K> map : maps){
            startTime = System.nanoTime();
            for(int i = 0; i < collectionSize; i++){
                map.containsKey(initArray[i]);
            }
            printEstTime(map, startTime);
        }
        newLine();
    }

    private static <T, K> void remove(T[] initArray, Map<T, K>... maps){

        System.out.println("Removing: ");

        for(Map<T, K> map : maps){
            startTime = System.nanoTime();
            for(int i = 0; i < collectionSize; i++){
                map.remove(initArray[i]);
            }
            printEstTime(map, startTime);
        }
        newLine();
    }

    private static <T> void compareSpeeds(T[] initArray, Set<T>... sets){
        add(initArray, sets);
        contains(initArray, sets);
        remove(initArray, sets);
    }

    private static <T> void compareSpeeds(T[] initArray, List<T>... lists){
        add(initArray, lists);
        searche(initArray, lists);
        remove(initArray, lists);
    }

    private static <T, K> void compareSpeeds(T[] initArray, K initValue, Map<T, K>... maps){
        put(initArray, maps);
        contains(initArray, maps);
        remove(initArray, maps);
    }

    public static void main(String[] args) {


        long startTime = 0, estimatedTime = 0;

        /* init array of values */
        for(int i = 0; i < collectionSize; i++){
            values[i] = Integer.valueOf((int)(Math.random() * 100));
        }

        /* array and linked lists */
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        compareSpeeds(values, arrayList, linkedList);

        newLine();
        newLine();


        /* Sets */
        HashSet<Integer> hashSet = new HashSet<>();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        compareSpeeds(values, hashSet, linkedHashSet, treeSet);

        newLine();
        newLine();


        /* Maps */
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        compareSpeeds(values, new Integer(0), hashMap, linkedHashMap, treeMap);

    }
}
