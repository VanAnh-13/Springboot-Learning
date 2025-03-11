package com.example.levan.homeworkweek1.ex1.engine;

import org.springframework.stereotype.Component;

@Component
public class GasolineEngine implements Engine{
    @Override
    public void info() {
        System.out.println("gas engine");
    }
}
