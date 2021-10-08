package com.FlipFit.service;

import com.FlipFit.entity.User;

import java.util.List;

public class UserService {
    public static User getUser(String userName) {
        List<User> users = FlipFitService.getUsers();
        for (User user : users) {
            if (user.getUsername().equals(userName)) {
                return user;
            }
        }
        return null;
    }
}
