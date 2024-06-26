package com.example.abstractClasses;

public abstract class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public abstract String getDesignation();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
