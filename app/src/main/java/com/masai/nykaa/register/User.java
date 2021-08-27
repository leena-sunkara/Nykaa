package com.masai.nykaa.register;

public class User {
    private String email, password, name, number;

    public User() {
    }

    public User(String email, String password, String name, String number) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
