package com.example.levan.homeworkweek1.ex2.payment;

import org.springframework.stereotype.Component;

@Component
public class PayPalPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Pay by PayPal");
    }
}
