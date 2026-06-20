package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        System.out.println("---------------BeanFactory Started--------------");

        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        System.out.println("-----------Bean file Loaded---------------");

        System.out.println("Sending Request..........");
        Car car = context.getBean(Car.class);

        car.drive();
    }
}
