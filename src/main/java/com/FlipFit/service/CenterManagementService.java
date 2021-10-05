package com.FlipFit.service;

import com.FlipFit.entity.Center;
import com.FlipFit.entity.Slot;
import com.FlipFit.entity.Workout;

import java.util.HashMap;
import java.util.List;

public class CenterManagementService {
    public static void addCenterActivities(String centerName, List<Workout> workouts) {
        Center center=CenterManagementService.getCenter(centerName);
        if(center != null) {
            center.setWorkouts(workouts);
        }
    }
    public static Center getCenter(String centerName){
        List<Center> centers= FlipFitService.getCenters();
        for(Center center:centers)
        {
            if(center.getName().equals(centerName)){
                return center;
            }
        }
        return null;
    }
    public static void addCenterTimings(String centerName, List<Slot> slots) {
        Center center=CenterManagementService.getCenter(centerName);
        if(center != null) {
            center.setSlots(slots);
        }
    }
    public static void addWorkout(String centerName, int startTime, int endTime, String workout, int capacity) {
        Center center=CenterManagementService.getCenter(centerName);

        if(center != null) {
            HashMap<String,Integer> workoutCapacity=center.getWorkoutCapacity();
            workoutCapacity.put(startTime + endTime + workout,capacity);
            center.setWorkoutCapacity(workoutCapacity);
        }
    }
}
