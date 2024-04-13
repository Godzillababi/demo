package com.example.demo.java.Employee;

import java.time.LocalDate;
import java.util.Random;

public class Employee {

    private static int nextId;

    static {
        Random generator = new Random();
        nextId = generator.nextInt(1000);
    }
    private double salary;
    private LocalDate hireDay;
    private int id;

    private String name = "";

    {
        id = nextId;
        nextId++;
    }

    public Employee() {

    }

    public Employee(String name) {
        this(name, 15000);
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.id = 0;
    }

    public static void main(String[] args) {
        Employee employee = new Employee("jcy", 5000);
        System.out.println("name: " + employee.getName() + " salary: " + employee.getSalary());
    }

    public Employee(String name, double salary, int year, int month, int day) {
        this.hireDay = LocalDate.of(year, month, day);
        this.name = name;
        this.salary = salary;
    }

    public static int getNextId() {
        return nextId;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }

    public void raiseSalary(double raise) {
        double newSalary = this.salary * raise / 100;
        this.salary += newSalary;
    }

}