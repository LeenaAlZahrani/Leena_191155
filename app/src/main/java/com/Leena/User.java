package com.Leena;

import android.widget.Button;

public class User {



    private int userId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;


    public User() {
    }

    public User(int userId, String firstName, String lastName, String phoneNumber, String emailAddress) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
