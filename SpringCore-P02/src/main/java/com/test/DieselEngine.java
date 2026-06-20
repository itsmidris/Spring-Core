package com.test;

public class DieselEngine implements Engine{

    public DieselEngine() {
        System.out.println("Diesel Constructor");
    }

    @Override
    public int start() {
        return 1;
    }
}
