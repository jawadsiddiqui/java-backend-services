package com.serializablepractice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializableDemo {
    public static void main(String[] args) {
        SerializableExample serializableExample = new SerializableExample(222, "John");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("f.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(serializableExample);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
