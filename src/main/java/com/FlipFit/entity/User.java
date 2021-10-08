package com.FlipFit.entity;

import java.util.List;

public class User {
    String username;
    private List<Booking> bookings;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
