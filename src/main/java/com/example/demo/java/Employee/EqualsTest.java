package com.example.demo.java.Employee;

public class EqualsTest {
    public static void main(String[] args) {
        Employee e1 = new Employee("John", 50000);
        Employee m1 = new Manager("John", 50000);
        boolean result = e1.equals(m1);
        System.out.println(result);
    }
}


