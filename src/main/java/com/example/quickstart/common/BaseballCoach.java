package com.example.quickstart.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach  implements  Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice your specified baseball workouts";
    }
}
