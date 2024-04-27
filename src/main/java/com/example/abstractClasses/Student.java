package com.example.abstractClasses;

public class Student extends Person {

    private String major;

    public Student(String name, String major) {
        super(name);
        this.major = major;
    }

    public String getDesignation() {
        return "a student majoring in " + major;
    }

}
