package com.example.demo.managers;

import com.example.demo.exceptions.UserAlreadyExistException;
import com.example.demo.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    Map<String, User> users = new HashMap<>();

    public void addUser(User user){
        if(users.containsKey(user.getId())){
            throw new UserAlreadyExistException();
        }
        users.put(user.getId(), user);
    }

    public User getUser(String id){
        if(!users.containsKey(id)){
            throw new UserAlreadyExistException();
        }
        return users.get(id);
    }
}
