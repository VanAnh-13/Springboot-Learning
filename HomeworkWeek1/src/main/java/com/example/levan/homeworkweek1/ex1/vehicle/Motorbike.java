package com.example.levan.homeworkweek1.ex1.vehicle;

import com.example.levan.homeworkweek1.ex1.engine.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@SuppressWarnings({"FieldCanBeLocal"})
@Component
public class Motorbike implements Vehicle {
    private final Engine engine;

    @Autowired
    public Motorbike(@Qualifier("gasolineEngine") Engine engine) {
        this.engine = engine;
    }
}
