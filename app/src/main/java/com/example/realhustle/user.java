package com.example.realhustle;

public class user {
    String Firstname,Lastname, Age,Username;

    public user(String firstname, String lastname, String age, String username) {
        Firstname = firstname;
        Lastname = lastname;
        Age = age;
        Username = username;
    }

    public user() {

    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}
