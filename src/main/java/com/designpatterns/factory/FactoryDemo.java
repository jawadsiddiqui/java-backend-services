package com.designpatterns.factory;

import java.util.Calendar;

public class FactoryDemo {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();

        //System.out.println(cal);
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));

        System.out.println(getShape("Circle"));
        IShape shape = getShape("Circle");

        shape.draw();

    }

    public static IShape getShape (String shapeType){
        if(shapeType == null) {
            return  null;
        }
        if(shapeType.equalsIgnoreCase("Circle")){
            return new Circle();
        }
        return null;
    }
}
