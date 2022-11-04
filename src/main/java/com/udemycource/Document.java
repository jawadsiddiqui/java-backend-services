package com.udemycource;


public class Document {
}

interface Machine {
    public void print(Document d);
    public void fax(Document d);
    public void scan(Document d);
}

class MultifunctionPrinter implements Machine
{

    @Override
    public void print(Document d) {

    }

    @Override
    public void fax(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}