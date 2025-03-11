package com.example.levan.homeworkweek1.ex2.payment;

import org.springframework.stereotype.Component;

@Component
public class CreditCardPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Pay by credit card");
    }
}
