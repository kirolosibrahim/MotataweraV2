package com.kmk.motatawerav2.pojo;


public class  UsersModel {

 private static String id;
 private String password;
 private String name;
 private String picture;
 private String gender;
 private String specialty;
 private String level;

    public UsersModel() {
    }

    public UsersModel(String id, String password, String name, String picture, String gender, String specialty, String level) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.picture = picture;
        this.gender = gender;
        this.specialty = specialty;
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}

