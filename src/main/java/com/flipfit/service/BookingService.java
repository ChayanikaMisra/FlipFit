package com.flipfit.service;

import com.flipfit.entity.Booking;
import com.flipfit.entity.User;

import java.util.List;

public class BookingService {
    public static void createBooking(String userName, String centerName, String workout) {
        int availableCapacity = CenterManagementService.checkCenterWorkoutAvailability(centerName, workout);
        if (availableCapacity > 0) {
            User user = UserService.getUser(userName);

            Booking booking = new Booking(centerName, workout);
            if (user != null) {
                List<Booking> bookings = user.getBookings();
                bookings.add(booking);
                user.setBookings(bookings);
                System.out.println("booking done");
            }

        }

    }
}
