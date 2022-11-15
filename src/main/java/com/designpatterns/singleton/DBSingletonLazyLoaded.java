package com.designpatterns.singleton;

public class DBSingletonLazyLoaded {
    private static DBSingletonLazyLoaded instance = null;

    private DBSingletonLazyLoaded() {}

    public static DBSingletonLazyLoaded getInstance() {
        if(instance == null) {
            instance = new DBSingletonLazyLoaded();
        }
        return instance;
    }
}
