package com.FlipFit.entity;

import java.util.List;

public class Center {
    String name;
    List<Slot> slots;
    List<Workout> workouts;

    public Center(String name, List<Slot> slots, List<Workout> workoutTypes) {
        this.name = name;
        this.slots = slots;
        this.workouts = workoutTypes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
