package com.podval.web;

import java.util.HashMap;
import java.util.Map;

public class Users {

    Map<String, User> users;

    Users(){
        users = new HashMap<>();
    }

    Users(Map<String, User> users){
        this.users = new HashMap<>(users);
    }

    Users(Object[] objects){
        users = new HashMap<>();

        for (Object object : objects){
            String[] pair = object.toString().split(" ");
            users.put(pair[0], new User(pair[0], pair[1]));
        }
    }

    public User get(String login){
        return users.get(login);
    }

    public void add(String login, String password){
        users.put(login, new User(login, password));
    }

    public void add(String pair){
        String[] splited = pair.split(" ");
        users.put(splited[0], new User(splited[0], splited[1]));
    }

}
