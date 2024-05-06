package com.example.interfaces;

import java.util.Arrays;

public class EmployeeSortTest {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("John", 30),
                new Employee("Jane", 25),
                new Employee("Bob", 35),
                new Employee("Alice", 20)
        };

        Arrays.sort(employees);

        for (Employee employee : employees) {
            System.out.println(employee.getName() + " - " + employee.getSalary());
        }
    }
}
