package com.FlipFit.entity;

import java.util.HashMap;
import java.util.List;

public class Center {
    String name;
    HashMap<String, Integer> workoutCapacity;
    List<Slot> slots;
    List<Workout> workouts;

    public Center(String name, HashMap<String, Integer> workoutCapacity, List<Slot> slots, List<Workout> workoutTypes) {
        this.name = name;
        this.workoutCapacity = workoutCapacity;
        this.slots = slots;
        this.workouts = workoutTypes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Integer> getWorkoutCapacity() {
        return workoutCapacity;
    }

    public void setWorkoutCapacity(HashMap<String, Integer> workoutCapacity) {
        this.workoutCapacity = workoutCapacity;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }


}
