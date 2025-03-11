package com.example.levan.homeworkweek1.ex1.user;

import com.example.levan.homeworkweek1.ex1.engine.Engine;
import com.example.levan.homeworkweek1.ex1.vehicle.Vehicle;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@SuppressWarnings({"FieldCanBeLocal"})
@Component
public class Person {
    private final Vehicle vehicle;
    private final Engine engine;

    public Person(@Qualifier("car") Vehicle vehicle, @Qualifier("electricEngine") Engine engine) {
        this.vehicle = vehicle;
        this.engine = engine;
    }

    public void info() {
        System.out.println(this.engine.getClass().getName() + "\n" + this.vehicle.getClass().getName());
    }
}
