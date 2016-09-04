package com.example.entity;

/**
 * Created by Mustafa on 9/3/2016.
 */
public class Credentials {
    private String emailId;
    private String password;

    public Credentials(){}

    public Credentials(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
