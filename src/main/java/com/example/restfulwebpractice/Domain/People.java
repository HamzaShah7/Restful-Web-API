package com.example.restfulwebpractice.Domain;

public class People {
    private String Name;
    private String Address;
    private int age;

    public People(String name, String address, int age) {
        Name = name;
        Address = address;
        this.age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
