package com.example.levan.homeworkweek1.ex1.vehicle;

import com.example.levan.homeworkweek1.ex1.engine.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@SuppressWarnings({"FieldCanBeLocal"})
@Component
public class Car implements Vehicle {
    private final Engine engine;

    @Autowired
    public Car (@Qualifier("electricEngine") Engine engine) {
        this.engine = engine;
    }
}
