package com.example.test;

import com.example.bean.Employee;

public class StaticTest {

    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("jcy", 5000);
        staff[1] = new Employee("cxy", 10000);
        staff[2] = new Employee("gqp", 15000);

        for (Employee e : staff) {
            int id = Employee.getNextId();
            System.out.println("name: " + e.getName() + " salary: " + e.getSalary() + " id: " + e.getId());
            System.out.println("id: " + id + " salary: " + e.getSalary());
        }

    }
}
