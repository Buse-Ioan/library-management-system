package com.itschool.library.utils.design_pattern.factory2;

public class SUV implements Car {

    @Override
    public void assemble() {
        System.out.println("Assembling an SUV car");
    }
}