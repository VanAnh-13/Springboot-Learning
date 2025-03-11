package com.example.levan.homeworkweek1.ex1.engine;

import org.springframework.stereotype.Component;

@Component
public class ElectricEngine implements Engine{
    @Override
    public void info() {
        System.out.println("electric engine");
    }
}
