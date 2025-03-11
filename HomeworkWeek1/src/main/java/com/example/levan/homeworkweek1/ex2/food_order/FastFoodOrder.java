package com.example.levan.homeworkweek1.ex2.food_order;

import org.springframework.stereotype.Component;

@Component
public class FastFoodOrder implements FoodOrder {

    @Override
    public void placeOrder() {
        System.out.println("Order Fast Food");
    }
}
