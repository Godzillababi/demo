package com.example.demo.java;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("jcy", 13500, 1995, 5, 20);
        employees[1] = new Employee("cxy", 5600, 1995, 7, 30);
        employees[2] = new Employee("gqp", 12000, 1993, 12, 24);

        for (Employee employee : employees) {
            employee.raiseSalary(30);
        }

        for (Employee employee : employees) {
            System.out.println("name: " + employee.getName() + ", salary: " + employee.getSalary() + " hirDay: " + employee.getHireDay());
        }


    }
}
