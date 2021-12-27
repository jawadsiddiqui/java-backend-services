package com.problems.dto;

public class NamePhoneEmailDTO {

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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    String Name;
    String Phone;
    String Email;

    public NamePhoneEmailDTO(String name, String phone, String email){
        this.Name = name;
        Phone = phone;
        Email = email;
    }
}
