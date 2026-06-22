package com.test;

public class PetrolEngine implements Engine{


    public PetrolEngine() {
        System.out.println("Petrol Constructor");
    }

    @Override
    public int start() {
        return 1;
    }
}
