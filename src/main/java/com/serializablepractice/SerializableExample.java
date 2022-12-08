package com.serializablepractice;

import java.io.Serializable;

public class SerializableExample implements Serializable {
    int id;
    String name;

    public SerializableExample(int id, String name){
        this.id = id;
        this.name = name;
    }
}
