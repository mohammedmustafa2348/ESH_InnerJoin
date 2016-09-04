package com.example.entity;

/**
 * Created by Mustafa on 8/30/2016.
 */
public class User {
    private long userId;
    private String name;
    private String facebookID;
    private String gender;
    private int age;
    private String location;
    private Credentials userCredentials;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacebookID() {
        return facebookID;
    }

    public void setFacebookID(String facebookID) {
        this.facebookID = facebookID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Credentials getUserCredentials() {
        if(userCredentials == null){
            userCredentials = new Credentials();
        }
        return userCredentials;
    }

    public void setUserCredentials(Credentials userCredentials) {
        this.userCredentials = userCredentials;
    }
}

