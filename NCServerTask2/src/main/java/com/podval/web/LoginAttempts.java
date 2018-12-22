package com.podval.web;

import java.util.HashMap;
import java.util.List;

public class LoginAttempts {

    private static HashMap<String, Integer> count = new HashMap<>();

    public static Integer get(String key){
        return count.get(key);
    }

    public static Boolean isContain(String key){ return count.containsKey(key); }

    public static void inc(String key){
        count.put(key, count.get(key) + 1);
    }

    public static void zeroize(String key){
        count.put(key, 0);
    }

    public static void add(String key){ count.put(key, 0); }

}
