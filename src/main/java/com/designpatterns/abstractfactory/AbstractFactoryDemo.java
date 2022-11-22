package com.designpatterns.abstractfactory;

public class AbstractFactoryDemo {
    public static void main(String[] args) {

        Computer pc = ComputerFactory.createComputer(new PCFactory("10GB","1TB"));

        System.out.println(pc.getHDD());


        Computer laptop = ComputerFactory.createComputer(new LaptopFactory());
        System.out.println(laptop.getHDD());


    }
}
