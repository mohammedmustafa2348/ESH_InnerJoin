package com.example.api;

import com.example.entity.User;

/**
 * Created by Mustafa on 9/3/2016.
 */
//url: paleo.co.in/InsertUser.php

public class UserDao {
    User user;

    public User getUser(String userId){
        return user;
    }

    public boolean storeUser(User user){
        return true;
    }

    public boolean updateUser(User user){
        return true;
    }

    public boolean deleteUser(String userId){
        return true;
    }
}
