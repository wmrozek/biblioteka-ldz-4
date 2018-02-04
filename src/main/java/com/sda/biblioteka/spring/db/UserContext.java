package com.sda.biblioteka.spring.db;

import com.sda.biblioteka.spring.db.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserContext {
    private static UserContext instance;

    private List<User> users;

    public static UserContext getInstance(){
        if (instance == null){
            instance = new UserContext();
        }
        return instance;
    }

    private UserContext() {
        users = new ArrayList<>();
    }

    public User findUser(String login){
        //TODO implementation
        return null;
    }

    public void addUser(User user){
        users.add(user);
    }

    public int getUsersCount(){
        return users.size();
    }

}
