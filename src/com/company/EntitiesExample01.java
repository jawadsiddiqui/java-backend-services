package com.company;

public class EntitiesExample01 {
    private long Code;
    private String Name;

    public long getCode() {
        return Code;
    }

    public void setCode(long code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "EntitiesExample01{" +
                "Code=" + Code +
                ", Name='" + Name + '\'' +
                '}';
    }
}
