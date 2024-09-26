package com.itschool.library.utils.design_pattern.factory2;

public class TestCarFactory {

    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();

        Car suv = carFactory.createCar("suv");
        suv.assemble();

        Car sedan = carFactory.createCar("sedan");
        sedan.assemble();

        Car hatchback = carFactory.createCar("hatchback");
        hatchback.assemble();
    }
}