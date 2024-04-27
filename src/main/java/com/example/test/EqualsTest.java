package com.example.test;

import com.example.bean.Employee;
import com.example.bean.Manager;

public class EqualsTest {
    public static void main(String[] args) {
        Employee e1 = new Employee("John", 50000);
        Employee m1 = new Manager("John", 50000);
        boolean result = e1.equals(m1);
        int result1 = e1.hashCode();
        int result2 = m1.hashCode();
        System.out.println("result1 = " + result1 + ", result2 = " + result2 + ", result = " + result);

    }
}


