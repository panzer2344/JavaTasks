package com.podval;

import java.util.*;

public class CollectionsTests {

    public static void main(String[] args) {
        final int collectionSize = 10000;

        long startTime = 0, estimatedTime = 0;

        /* init array of values */
        Integer[] values = new Integer[collectionSize];
        for(int i = 0; i < collectionSize; i++){
            values[i] = Integer.valueOf((int)(Math.random() * 100));
        }

        /* array and linked lists */
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();


        /* adding */
        System.out.println("Adding: ");
        System.out.println();

        /* arrayList */
        startTime = System.nanoTime();
        for(int i = 0; i < collectionSize; i++){
            arrayList.add(values[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("arrayList: " + estimatedTime);

        /* linkedList */
        startTime = System.nanoTime();
        for(int i = 0; i < collectionSize; i++){
            linkedList.add(values[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("linkedList: " + estimatedTime);
        System.out.println();



        /* searching */
        System.out.println("Searching: ");
        System.out.println();

        /* arrayList */
        startTime = System.nanoTime();
        for(int i = collectionSize - 1; i > 0; i--){
            arrayList.indexOf(values[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("arrayList: " + estimatedTime);

        /* linkedList */
        startTime = System.nanoTime();
        for(int i = collectionSize - 1; i > 0; i--){
            linkedList.indexOf(values[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("linkedList: " + estimatedTime);
        System.out.println();


        /* Removing */
        System.out.println("Removing: ");
        System.out.println();

        /* arrayList */
        startTime = System.nanoTime();
        for(int i = collectionSize - 1; i > 0; i--){
            arrayList.remove(values[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("arrayList: " + estimatedTime);

        /* linkedList */
        startTime = System.nanoTime();
        for(int i = collectionSize - 1; i > 0; i--){
            linkedList.remove(values[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("linkedList: " + estimatedTime);
        System.out.println();



        /*                 */
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        /*                 */


        /* Sets */
        HashSet<Integer> hashSet = new HashSet<>();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();


        /* adding */
        System.out.println("Adding: ");
        System.out.println();

        /* hashSet */
        startTime = System.nanoTime();
        for(int i = 0; i < collectionSize; i++){
            hashSet.add(values[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("HashSet: " + estimatedTime);

        /* LinkedHashSet */
        startTime = System.nanoTime();
        for(int i = 0; i < collectionSize; i++){
            linkedHashSet.add(values[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedHashSet: " + estimatedTime);
        System.out.println();

        /* TreeSet */
        startTime = System.nanoTime();
        for(int i = 0; i < collectionSize; i++){
            treeSet.add(values[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("TreeSet: " + estimatedTime);
        System.out.println();



        /* searching */
        System.out.println("Searching: ");
        System.out.println();

        /* HashSet */
        startTime = System.nanoTime();
        for(int i = collectionSize - 1; i > 0; i--){
            hashSet.contains(values[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("HashSet: " + estimatedTime);

        /* LinkedHashSet */
        startTime = System.nanoTime();
        for(int i = collectionSize - 1; i > 0; i--){
            linkedHashSet.contains(values[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("linkedHashList: " + estimatedTime);
        System.out.println();

        /* TreeSet */
        startTime = System.nanoTime();
        for(int i = collectionSize - 1; i > 0; i--){
            treeSet.contains(values[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("treeSet: " + estimatedTime);
        System.out.println();


        /* Removing */
        System.out.println("Removing: ");
        System.out.println();

        /* HashSet */
        startTime = System.nanoTime();
        for(int i = collectionSize - 1; i > 0; i--){
            hashSet.remove(values[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("HashSet: " + estimatedTime);

        /* LinkedHashSet */
        startTime = System.nanoTime();
        for(int i = collectionSize - 1; i > 0; i--){
            linkedHashSet.remove(values[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("linkedHashSet: " + estimatedTime);
        System.out.println();

        /* TreeSet */
        startTime = System.nanoTime();
        for(int i = collectionSize - 1; i > 0; i--){
            treeSet.remove(values[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("treeSet: " + estimatedTime);
        System.out.println();




        /*                 */
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        /*                 */


        /* Sets */
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();


        /* adding */
        System.out.println("Adding: ");
        System.out.println();

        /* hashMap */
        startTime = System.nanoTime();
        for(int i = 0; i < collectionSize; i++){
            hashMap.put(values[i], Integer.valueOf(0));
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("HashMap: " + estimatedTime);

        /* linkedHashMap */
        startTime = System.nanoTime();
        for(int i = 0; i < collectionSize; i++){
            linkedHashMap.put(values[i], Integer.valueOf(0));
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedHashMap: " + estimatedTime);
        System.out.println();

        /* TreeMap */
        startTime = System.nanoTime();
        for(int i = 0; i < collectionSize; i++){
            treeMap.put(values[i], Integer.valueOf(0));
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("TreeMap: " + estimatedTime);
        System.out.println();



        /* searching */
        System.out.println("Searching: ");
        System.out.println();

        /* HashMap */
        startTime = System.nanoTime();
        for(int i = collectionSize - 1; i > 0; i--){
            hashMap.containsKey(values[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("HashMap: " + estimatedTime);

        /* LinkedHashMap */
        startTime = System.nanoTime();
        for(int i = collectionSize - 1; i > 0; i--){
            linkedHashMap.containsKey(values[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("linkedHashMap: " + estimatedTime);
        System.out.println();

        /* TreeMap */
        startTime = System.nanoTime();
        for(int i = collectionSize - 1; i > 0; i--){
            treeMap.containsKey(values[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("treeMap: " + estimatedTime);
        System.out.println();


        /* Removing */
        System.out.println("Removing: ");
        System.out.println();

        /* HashMap */
        startTime = System.nanoTime();
        for(int i = collectionSize - 1; i > 0; i--){
            hashMap.remove(values[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("HashMap: " + estimatedTime);

        /* LinkedHashMap */
        startTime = System.nanoTime();
        for(int i = collectionSize - 1; i > 0; i--){
            linkedHashMap.remove(values[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("linkedHashMap: " + estimatedTime);
        System.out.println();

        /* TreeMap */
        startTime = System.nanoTime();
        for(int i = collectionSize - 1; i > 0; i--){
            treeMap.remove(values[i]);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("treeMap: " + estimatedTime);
        System.out.println();
    }
}
