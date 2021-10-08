package com.FlipFit.service;

import com.FlipFit.entity.Center;
import com.FlipFit.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FlipFitService {
    private static List<User> users;
    private static List<Center> centers;

    public FlipFitService(List<User> users, List<Center> centers) {
        FlipFitService.users = users;
        FlipFitService.centers = centers;
    }

    public static List<Center> getCenters() {
        return centers;
    }

    public void setCenters(List<Center> centers) {
        FlipFitService.centers = centers;
    }

    public static List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        FlipFitService.users = users;
    }

    public void register(String username) {
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
        System.out.println("added new user: " + username);


    }

    public void addCenter(String name) {
        Center center = new Center(name, new ArrayList<>(), new ArrayList<>());
        centers.add(center);
        System.out.println("\n\ncenters :");
        for (Center c : centers) {
            System.out.print(c.getName() + " ");
        }
        System.out.println("\n");

    }


}
