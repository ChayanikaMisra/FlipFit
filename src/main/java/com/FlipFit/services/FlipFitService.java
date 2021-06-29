package com.FlipFit.services;

import com.FlipFit.exceptions.CenterNotFoundException;
import com.FlipFit.exceptions.SlotMismatchException;
import com.FlipFit.exceptions.WorkoutNotFoundException;
import com.FlipFit.models.User;
import com.FlipFit.models.Center;
import com.FlipFit.models.Slot;
import com.FlipFit.models.Workout;

import java.util.ArrayList;
import java.util.List;

public class FlipFitService {
    private List<User> users;
    private List<Center> centers;

    public FlipFitService(List<User> users, List<Center> centers) {
        this.users = users;
        this.centers = centers;
    }

    public List<Center> getCenters() {
        return centers;
    }

    public void setCenters(List<Center> centers) {
        this.centers = centers;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void register(String username) {
        if (!this.users.isEmpty()) {
            for (User user : this.users) {
                if (user.getUsername() == username) {
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
        Center center = new Center(name, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        this.centers.add(center);
        System.out.println("\n\ncenters :");
        for (Center c : this.centers) {
            System.out.print(c.getName() + " ");
        }
        System.out.println("\n");

    }

    public void addCenterTimingsAndWorkouts(String name, int startTime, int endTime, List<String> workoutTypes) {
        Center center = Center.getCenterByName(this.centers, name);
        Center.addTimings(center, startTime, endTime);
        Center.addWorkoutTypes(center, workoutTypes);

    }

    public void addWorkout(String name, String workoutName, int startTime, int endTime, int capacity) {
        Center center = Center.getCenterByName(this.centers, name);

        Center.addWorkoutToCenter(center, workoutName, startTime, endTime, capacity);
    }

    public void viewWorkoutAvailability(String workoutName) {
        System.out.println("\n\nAvailable workouts");
        for (Center c : this.centers) {

            for (Workout w : c.getWorkouts()) {

                if (w.getType().equals(workoutName)) {
                    System.out.println(c.getName() + " " + workoutName + " " + w.getSlot().getStartTime() + " " + w.getSlot().getEndTime());
                }
            }
        }
    }

    public void bookSession(String username, String center, String workoutType, int startTime, int endTime) throws SlotMismatchException, CenterNotFoundException, WorkoutNotFoundException {
        boolean centerFound = false;
        boolean workoutFound = false;

        for (Center c : this.centers) {
            if ((c.getName()).equals(center)) {
                centerFound = true;

                for (Workout w : c.getWorkouts()) {
                    if (w.getType().equals(workoutType)) {
                        workoutFound = true;
                        Slot s = w.getSlot();

                        if (s.getStartTime() == startTime && s.getEndTime() == endTime) {
                            System.out.println("booking done");
                            break;
                        } else {
                            throw new SlotMismatchException("slot mismatch");
                        }

                    }

                }

            }
        }
        if (!centerFound) {
            throw new CenterNotFoundException("center not found");
        }
        if (!workoutFound) {
            throw new WorkoutNotFoundException("workout not found");
        }
    }


}