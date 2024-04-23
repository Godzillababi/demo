package com.example.demo.java.Employee;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

/**
 * 员工对象类
 *
 * @author jcy
 * @since 2024.04.11
 */
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

    /**
     * Raise the salary of an employee.
     *
     * @param raise the percentage by which to raise the salary(e.g. 10 means 10%)
     */
    public void raiseSalary(double raise) {
        double newSalary = this.salary * raise / 100;
        this.salary += newSalary;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (this.getClass() != otherObject.getClass()) return false;
        Employee employee = (Employee) otherObject;
        return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name) &&
                Objects.equals(this.salary, employee.salary) && Objects.equals(this.hireDay, employee.hireDay);
    }

}
