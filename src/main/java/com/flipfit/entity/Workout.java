package com.flipfit.entity;

public class Workout {
    private String type;
    private Slot slot;
    private int capacity;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Workout() {
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Workout(String type, Slot slot, int capacity) {
        this.type = type;
        this.slot = slot;
        this.capacity = capacity;
    }
}
