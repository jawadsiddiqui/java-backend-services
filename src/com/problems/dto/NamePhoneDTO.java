package com.problems.dto;

public class NamePhoneDTO {
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    String Name;
    String Phone;

    public NamePhoneDTO(String name, String phone){
        this.Name = name;
        Phone = phone;
    }
}
