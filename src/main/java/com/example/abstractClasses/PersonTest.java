package com.example.abstractClasses;

public class PersonTest {
    public static void main(String[] args) {
        Person[] person = new Person[2];
        person[0] = new Employee("jcy", 5000, 1995, 5, 20);
        person[1] = new Student("cxy", "student");

        for (Person person1 : person) {
            System.out.println(person1.getName() + "," + person1.getDesignation());
        }
    }
}
