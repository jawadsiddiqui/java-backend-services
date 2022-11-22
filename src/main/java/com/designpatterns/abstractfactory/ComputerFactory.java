package com.designpatterns.abstractfactory;

public class ComputerFactory {
    public static Computer createComputer(ComputerAbstractFactory computerAbstractFactory){
        return computerAbstractFactory.createComputer();
    }
}
