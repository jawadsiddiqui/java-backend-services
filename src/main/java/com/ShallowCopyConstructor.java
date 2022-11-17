package com;

public class ShallowCopyConstructor {
    private String name;
    private String address;

    public ShallowCopyConstructor(ShallowCopyConstructor copyConstructor){
        name = copyConstructor.name;
        address = copyConstructor.address;
    }
}
