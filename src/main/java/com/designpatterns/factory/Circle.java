package com.designpatterns.factory;

public class Circle implements IShape {
    @Override
    public void draw() {
        System.out.println("this draw is for Circle");
    }
}
