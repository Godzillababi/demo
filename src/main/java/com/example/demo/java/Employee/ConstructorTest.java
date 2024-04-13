package com.example.demo.java.Employee;

public class ConstructorTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Jcy", 20000);
        staff[1] = new Employee("cxy");
        staff[2] = new Employee();

        for (Employee e : staff) {
            System.out.println("name: " + e.getName() + ", salary: " + e.getSalary() + ", id: " + e.getId());
        }
    }
}
