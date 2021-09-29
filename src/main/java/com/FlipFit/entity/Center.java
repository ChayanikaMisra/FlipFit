package com.FlipFit.entity;

import java.util.ArrayList;
import java.util.List;

public class Center {
    String name;
    List<Workout> workouts;
    List<Slot> timings;
    List<String> workoutTypes;

    public List<String> getWorkoutTypes() {
        return workoutTypes;
    }

    public void setWorkoutTypes(List<String> workoutTypes) {
        this.workoutTypes = workoutTypes;
    }



    public Center(String name, List<Workout> workouts, List<Slot> timings, List<String> workoutTypes) {
        this.name = name;
        this.workouts = workouts;
        this.timings = timings;
        this.workoutTypes=workoutTypes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }

    public List<Slot> getTimings() {
        return timings;
    }

    public void setTimings(List<Slot> timings) {
        this.timings = timings;
    }

    public static Center getCenterByName(List<Center> centers, String name) {
        for(Center center: centers)
        {
            if((center.name).equals(name))
                return center;
            }

        return new Center(name, new ArrayList<>(),new ArrayList<>(), new ArrayList<>());
    }


    public static void addTimings(Center center, int startTime, int endTime) {
        Slot slot=new Slot(startTime,endTime);
        center.timings.add(slot);

    }
    public static void addWorkoutTypes(Center center, List<String> workoutTypes) {
        center.workoutTypes.addAll(workoutTypes);

    }
    public static void addWorkoutToCenter(Center center, String workoutName, int startTime, int endTime, int capacity)
    {
        if(!center.workoutTypes.contains(workoutName)) {
            System.out.println("this is not allowed because workout not added in center");
            return;
        }
        for(Slot s: center.timings)
        {
            if(startTime>=s.startTime && endTime<=s.endTime)
            {
                Slot workoutSlot=new Slot(startTime,endTime);
                Workout w=new Workout(workoutName,workoutSlot,capacity);
                center.workouts.add(w);
                System.out.println("workout added to center");
                return;
            }
        }
        System.out.println("this should not be allowed because of time");





    }
}
