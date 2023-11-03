package com.example.carrentalservice.model;
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int cprNumber;
    private int phoneNumber;

    public User() {

    }

    public User(String firstName, String lastName, String email, String password, int cprNumber, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.cprNumber = cprNumber;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public int getCprNumber() {
        return this.cprNumber;
    }

    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCprNumber(int cprNumber) {
        this.cprNumber = cprNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cprNumber='" + cprNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}