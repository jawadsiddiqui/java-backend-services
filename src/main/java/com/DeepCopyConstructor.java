package com;

public class DeepCopyConstructor {
    private String name;
    private String address;

    public DeepCopyConstructor(DeepCopyConstructor deepCopyConstructor){
       this.name = new Name(deepCopyConstructor.name).name;
    }

    public class Name{
        private String name;
        public Name(String name){
            this.name = name;
        }
    }
}
