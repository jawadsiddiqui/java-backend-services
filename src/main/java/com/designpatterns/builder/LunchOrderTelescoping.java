package com.designpatterns.builder;

public class LunchOrderTelescoping {
    private String bread;
    private String condiments;
    private String dressing;
    private String meat;

    public LunchOrderTelescoping(String bread)
    {
        this.bread = bread;
    }

    public LunchOrderTelescoping(String bread, String condiments)
    {
        this(bread);
        this.condiments = condiments;
    }
}
