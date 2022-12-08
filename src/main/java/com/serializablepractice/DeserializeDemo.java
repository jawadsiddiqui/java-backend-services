package com.serializablepractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeDemo {
    public static void main(String[] args) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("f.txt"));
            SerializableExample serializableExample = (SerializableExample) objectInputStream.readObject();
            System.out.println(serializableExample.id +","+ serializableExample.name);
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
