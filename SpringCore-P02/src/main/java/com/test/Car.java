package com.test;

public class Car {

    private Engine engine;

    public Engine getEngine() {
        return engine;
    }

    public Car(Engine engine) {

        System.out.println("Car Constructor");
        this.engine = engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void drive(){
        int start = engine.start();
        if (start>=1){
            System.out.println("Lets Drive");
        }else {
            System.out.println("Engine Not Started");
        }
    }
}
