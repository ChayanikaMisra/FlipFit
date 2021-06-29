package com.FlipFit.models;

public class Workout {
    String type;
    Slot slot;
    int capacity;

    public Workout(String type, Slot slot, int capacity) {
        this.type = type;
        this.slot = slot;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
}
