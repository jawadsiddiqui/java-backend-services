package com.designpatterns.factory;

import java.awt.*;

public class Rectangle implements IShape {

    @Override
    public void draw() {
        System.out.println("this Draw method is for Rectangle");
    }
}
