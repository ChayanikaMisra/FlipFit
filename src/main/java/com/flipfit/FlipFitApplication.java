package com.flipfit;

import com.flipfit.entity.Slot;
import com.flipfit.entity.Workout;
import com.flipfit.service.BookingService;
import com.flipfit.service.CenterManagementService;
import com.flipfit.service.FlipFitService;
import com.flipfit.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlipFitApplication {
    public static void main(String[] args) {
        FlipFitService flipFitService = new FlipFitService(new ArrayList<>(), new ArrayList<>());
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of Users: ");
        int noOfUsers = sc.nextInt();

        System.out.println("Add Users");
        for (int countUser = 0; countUser < noOfUsers; countUser++) {
            System.out.print("enter new user name:");
            String userName = sc.next();
            UserService.registerUser(userName);
        }


        System.out.print("Number of Centers: ");
        int noOfCenters = sc.nextInt();

        System.out.println("Add centers");
        for (int countCenter = 0; countCenter < noOfCenters; countCenter++) {
            System.out.print("enter new center name:");
            String centerName = sc.next();
            flipFitService.addCenter(centerName);
        }


        System.out.println("Add center Slots");
        System.out.print("Center name:");
        String centerName = sc.next();
        System.out.print("Number of Activities: ");
        int noOfActivities = sc.nextInt();
        List<Workout> workouts = new ArrayList<>();
        for (int countActivity = 0; countActivity < noOfActivities; countActivity++) {
            System.out.print("Activity name:");
            String activityName = sc.next();
            Workout workout = new Workout();
            workout.setType(activityName);
            workouts.add(workout);
        }
        CenterManagementService.addCenterActivities(centerName, workouts);


        System.out.println("Add center Slots");
        System.out.print("Center name:");
        centerName = sc.next();
        System.out.print("Number of Slots: ");
        int noOfSlots = sc.nextInt();
        List<Slot> slots = new ArrayList<>();
        for (int countSlot = 0; countSlot < noOfSlots; countSlot++) {
            System.out.print("Center Slot timings:");
            int centerStartTime = sc.nextInt();
            int centerEndTime = sc.nextInt();
            int startTime=centerStartTime;
            int endTime=centerStartTime+1;
            if(endTime<=startTime)
            {
                System.out.println("wrong timings");
                continue;
            }
            while(endTime<centerEndTime)
            {
                Slot slot = new Slot(startTime, endTime);
                slots.add(slot);
                startTime=endTime;
                endTime=startTime+1;
            }
        }
        CenterManagementService.addCenterTimings(centerName, slots);


        System.out.println("Add center Slots");
        System.out.print("Center name:");
        centerName = sc.next();
        System.out.print("Number of Workouts: ");
        int noOfWorkouts = sc.nextInt();
        for (int countWorkout = 0; countWorkout < noOfWorkouts; countWorkout++) {
            System.out.print("timings:");
            int startTime = sc.nextInt();
            int endTime = sc.nextInt();
            System.out.print("workout type:");
            String activityName = sc.next();
            System.out.print("capacity:");
            int capacity = sc.nextInt();
            CenterManagementService.addWorkout(centerName, startTime, endTime, activityName, capacity);
        }

        System.out.println("view workout availability");
        System.out.print("Workout name:");
        String workoutName = sc.next();
        CenterManagementService.viewWorkoutAvailability(workoutName);


        System.out.println("book session");
        System.out.print("user name:");
        String userName = sc.next();
        System.out.print("center name:");
        centerName = sc.next();
        System.out.print("workout name:");
        workoutName = sc.next();
        BookingService.createBooking(userName,centerName,workoutName);
    }
}
