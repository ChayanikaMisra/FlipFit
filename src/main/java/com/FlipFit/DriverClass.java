package com.FlipFit;

import com.FlipFit.services.FlipFitService;

import java.util.ArrayList;
import java.util.List;

public class DriverClass {
    public static void main(String[] args) {
        FlipFitService flipFitService = new FlipFitService(new ArrayList<>(), new ArrayList<>());
        flipFitService.register("John");
        flipFitService.register("John");


        flipFitService.addCenter("koramangala");
        flipFitService.addCenter("Bellandur");
        List<String> workoutTypes = new ArrayList<String>();
        workoutTypes.add("swimming");
        workoutTypes.add("weights");
        flipFitService.addCenterTimingsAndWorkouts("koramangala", 7, 10, workoutTypes);
        flipFitService.addCenterTimingsAndWorkouts("Bellandur", 7, 10, workoutTypes);


        flipFitService.addWorkout("koramangala", "weights", 18, 19, 100);
        flipFitService.addWorkout("koramangala", "cardio", 18, 19, 100);
        flipFitService.addWorkout("koramangala", "weights", 7, 8, 100);
        flipFitService.addWorkout("Bellandur", "weights", 7, 8, 100);



        flipFitService.viewWorkoutAvailability("weights");
        try {

            flipFitService.bookSession("Sourabh", "koramangala", "weights", 7, 8);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }

        flipFitService.viewWorkoutAvailability("weights");


    }
}
