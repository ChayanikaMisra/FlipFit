package com.flipfit.entity;

public class Booking {
    private String center;
    private String workout;

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getWorkout() {
        return workout;
    }

    public void setWorkout(String workout) {
        this.workout = workout;
    }

    public Booking(String center, String workout) {
        this.center = center;
        this.workout = workout;
    }
}
