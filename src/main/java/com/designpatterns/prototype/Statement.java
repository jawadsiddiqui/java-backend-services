package com.designpatterns.prototype;

public class Statement implements Cloneable{

    @Override
    public Statement clone() {
        try {
            return (Statement) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
