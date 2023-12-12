package com.example.carrentalservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class User implements UserDetails {
    @JsonProperty("firstName")
    private String FirstName;
    @JsonProperty("lastName")
    private String LastName;
    @JsonProperty("email")
    private String Email;
    @JsonProperty("password")
    private String Password;
    @JsonProperty("userName")
    private String UserName;
    @JsonProperty("phoneNumber")
    private long PhoneNumber;
    @JsonProperty("isAdmin")
    private boolean IsAdmin;


    public User() {

    }

    public User(String firstName, String lastName, String email, String password, String userName, long phoneNumber, boolean isAdmin) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Password = password;
        UserName = userName;
        PhoneNumber = phoneNumber;
        IsAdmin = isAdmin;
    }


    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return Email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return Password;
    }

    @Override
    public String getUsername() {
        return UserName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setPhoneNumber(long phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public boolean isAdmin() {
        return IsAdmin;
    }

    public void setAdmin(boolean admin) {
        IsAdmin = admin;
    }


    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public long getPhoneNumber() {
        return PhoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + FirstName + '\'' +
                ", lastName='" + LastName + '\'' +
                ", email='" + Email + '\'' +
                ", password='" + Password + '\'' +
                ", username='" + UserName + '\'' +
                ", phoneNumber='" + PhoneNumber + '\'' +
                '}';
    }
}