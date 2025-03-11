package com.example.levan.homeworkweek1;

import com.example.levan.homeworkweek1.ex1.user.Person;
import com.example.levan.homeworkweek1.ex2.customer.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class HomeworkWeek1Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.example.levan.homeworkweek1");

        Person person = applicationContext.getBean(Person.class);
        person.info();

        Customer customer = applicationContext.getBean(Customer.class);
        customer.orderFood();
    }

}
