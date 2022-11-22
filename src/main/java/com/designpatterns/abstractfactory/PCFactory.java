package com.designpatterns.abstractfactory;

public class PCFactory implements ComputerAbstractFactory{
    private String ram;
    private  String hdd;

    @Override
    public Computer createComputer() {
        return new PC(this.ram, this.hdd);
    }


    public PCFactory(String ram, String hdd){
        this.ram = ram;
        this.hdd = hdd;

    }
}
