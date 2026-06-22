package com.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.Beans;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        Motor m = context.getBean(Motor.class);
        m.doWork();

        context.close(); //Destroy Method
    }
}
