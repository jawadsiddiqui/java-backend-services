package com.designpatterns.abstractfactory;


//concrete class PC
public class PC implements Computer{
    private  String ram;
    private String HDD;

    public PC(String ram, String HDD){
        this.HDD = HDD;
        this.ram = ram;
    }

    @Override
    public String getRam() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.HDD;
    }
}
