package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        System.out.println("---------------BeanFactory Started--------------");

        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        System.out.println("-----------Bean file Loaded---------------");

        System.out.println("Sending Request..........");

        System.out.println("-------First Call--------");
        Car car1 = context.getBean(Car.class);
        System.out.println("-------Second Call--------");
        Car car2 = context.getBean(Car.class);
        System.out.println("Same object? " + (car1==car2));
        System.out.println("By default Singleton Scope Or WE CAN SET");

        System.out.println("-------First Call--------");
        PetrolEngine p1 = context.getBean(PetrolEngine.class);
        System.out.println("-------Second Call--------");
        PetrolEngine p2 = context.getBean(PetrolEngine.class);
        System.out.println("Same petrol Engine object? " + (p1==p2));
        System.out.println("We set the scope of petrol Engine Object");
    }
}