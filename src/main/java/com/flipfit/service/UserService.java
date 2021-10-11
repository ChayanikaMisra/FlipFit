package com.flipfit.service;

import com.flipfit.entity.User;

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
    public static void registerUser(String username) {
        List<User> users=FlipFitService.getUsers();
        if (!users.isEmpty()) {
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    System.out.println("User is already registered");
                    return;
                }
            }
        }
        User newUser = new User(username);
        users.add(newUser);
        FlipFitService.setUsers(users);
        System.out.println("added new user: " + username);


    }
}
