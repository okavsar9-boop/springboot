package com.example.quickstart.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class FunRestController {


        @Value("${coach.name}")
        private String coachMame;
        @Value("${team.name}")
        private String teamName;

        @GetMapping(path = "/teamInfo")
        public String getTeamInfo(){
            return "Coach : " + coachMame + ", Team : " + teamName ;
        }


        @GetMapping(path = "/")
        public String helloWorld(){
            return "Hello Ominakavsarrrrrr ! ";
        }
        @GetMapping(path = "/workout")
        public String getDailyWorkout(){
            return " Make sure you always come to the gym ";
        }
        @GetMapping(path = "/fortune")
        public String getDailyFortune(){
            return " Today is your lucky day ! ";
        }


    }
