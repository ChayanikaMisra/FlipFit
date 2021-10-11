package com.flipfit.service;

import com.flipfit.entity.Center;
import com.flipfit.entity.Slot;
import com.flipfit.entity.Workout;

import java.util.List;

public class CenterManagementService {
    public static void addCenterActivities(String centerName, List<Workout> workouts) {
        Center center = CenterManagementService.getCenter(centerName);
        if (center != null) {
            center.setWorkouts(workouts);
        }
    }

    public static Center getCenter(String centerName) {
        List<Center> centers = FlipFitService.getCenters();
        for (Center center : centers) {
            if (center.getName().equals(centerName)) {
                return center;
            }
        }
        return null;
    }

    public static void addCenterTimings(String centerName, List<Slot> slots) {
        Center center = CenterManagementService.getCenter(centerName);
        if (center != null) {
            center.setSlots(slots);
        }
    }

    public static void addWorkout(String centerName, int startTime, int endTime, String activityName, int capacity) {
        Center center = CenterManagementService.getCenter(centerName);
        if (center != null) {
            Slot slot = new Slot(startTime, endTime);
            Workout newWorkout = new Workout(activityName, slot, capacity);
            List<Workout> workouts = center.getWorkouts();
            workouts.add(newWorkout);
            center.setWorkouts(workouts);
        }
    }

    public static void viewWorkoutAvailability(String workoutName) {
        List<Center> centers = FlipFitService.getCenters();
        for (Center center : centers) {
            List<Workout> workouts = center.getWorkouts();
            for (Workout workout : workouts) {
                if (workout.getType().equals(workoutName) && workout.getCapacity() > 0) {
                    System.out.println(center.getName() + " " + workout.getType() + " " +
                            workout.getSlot().getStartTime() + " " +
                            workout.getSlot().getEndTime() + " " +
                            workout.getCapacity());
                }
            }
        }
    }

    public static int checkCenterWorkoutAvailability(String centerName, String workoutName)
    {
        Center center = CenterManagementService.getCenter(centerName);
        if(center!=null)
        {
            List<Workout> workouts=center.getWorkouts();
            for(Workout workout:workouts)
            {
                if(workout.getType().equals(workoutName) && workout.getCapacity()>=0)
                    return workout.getCapacity();
            }
        }
        return 0;
    }
}
