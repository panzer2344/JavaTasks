package com.podval.web;

import java.util.HashMap;
import java.util.Map;

public class Users {

    Map<String, User> users;

    public static final User NO_USER = new User("nouser", "nopass");
    public static final User EMPTY_USER = new User("", "");

    Users(){
        users = new HashMap<>();
    }

    Users(Map<String, User> users){
        this.users = new HashMap<>(users);
    }

    Users(Object[] objects){
        users = new HashMap<>();

        for (Object object : objects){
            if(!((String)object).equals("")) {
                String[] pair = object.toString().split(" ");
                users.put(pair[0], new User(pair[0], pair[1]));
            }
        }
    }

    public User get(String login){

        User result = users.get(login);
        if(result == null) {
            return NO_USER;
        }else{
            return result;
        }

    }

    public void add(String login, String password){
        users.put(login, new User(login, password));
    }

    public void add(String pair){
        String[] splited = pair.split(" ");
        users.put(splited[0], new User(splited[0], splited[1]));
    }

    @Override
    public String toString() {
        return "Users{" +
                "users=" + users +
                '}';
    }
}
