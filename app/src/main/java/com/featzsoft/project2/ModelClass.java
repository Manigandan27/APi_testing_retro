package com.featzsoft.project2;

public class ModelClass {

    private int id;
    private String name;//name
    private String email;//jb
    private String password;

    public ModelClass(String name, String email) {

        this.name = name;
        this.email = email;
    }

    public ModelClass() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

