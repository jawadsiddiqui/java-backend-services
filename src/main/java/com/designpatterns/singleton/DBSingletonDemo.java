package com.designpatterns.singleton;

public class DBSingletonDemo {
    public static void main(String[] args) {
        DBSingleton instance = DBSingleton.getInstance();

        //won't allow because constructure is private
        //DBSingleton test = new DBSingleton.getInstance();


        System.out.println(instance);
        DBSingleton anotherInstance = DBSingleton.getInstance();
        System.out.println(anotherInstance);


    }
}
