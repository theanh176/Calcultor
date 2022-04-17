package com.example.myapplication.model;

import java.util.HashMap;
import java.util.Map;

public class PhoneBooks {
    private String name;
    private String phone;

    public PhoneBooks(){

    }

    public PhoneBooks(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Name=" + name +
                ", Phone='" + phone + '\'' +
                '}';
    }
}
