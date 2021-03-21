package com.example.practice;

public class Person {
    String email;
    String pass;

    public Person(){}

    public Person(String email, String pas) {
        this.email = email;
        this.pass = pas;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPas() {
        return pass;
    }

    public void setPas(String pas) {
        this.pass = pas;
    }
}
