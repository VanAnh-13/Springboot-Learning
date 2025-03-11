package com.example.levan.homeworkweek1.ex2.customer;

import com.example.levan.homeworkweek1.ex2.food_order.FoodOrder;
import com.example.levan.homeworkweek1.ex2.payment.Payment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Customer {
    private final FoodOrder foodOrder;
    private final Payment payment;

    public Customer(@Qualifier("healthyFoodOrder") FoodOrder foodOrder, @Qualifier("payPalPayment") Payment payment) {
        this.foodOrder = foodOrder;
        this.payment = payment;
    }

    public void orderFood() {
        foodOrder.placeOrder();
        payment.pay();
    }
}
