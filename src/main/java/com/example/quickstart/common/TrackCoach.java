package com.example.quickstart.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Run 5 kms at the speed of 3.3 with the incline 13 !";
    }
}
