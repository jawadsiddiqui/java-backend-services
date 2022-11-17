package com.designpatterns.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable {

    private List<String> empList;

    public Employees(){
        empList = new ArrayList<>();
    }

    public void loadData(){
        empList.add("Jhon");
        empList.add("JhonD");
        empList.add("JhonA");
        empList.add("JhonB");

    }

    public List<String> getEmpList() {
        return empList;
    }



    @Override
    public Employees clone() {
        try {
            return (Employees) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

}
