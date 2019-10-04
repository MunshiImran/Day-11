package com.example.contactapps;

public class Contact {

    private String name;
    private String phone;
    private int photo;

    public Contact() {
    }

    public Contact(String name, String phone, int photo) {
        this.name = name;
        this.phone = phone;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getPhoto() {
        return photo;
    }
}
