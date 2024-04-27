package com.example.abstractClasses;

import java.time.LocalDate;
import java.util.Random;

/**
 * 员工对象类
 *
 * @author jcy
 * @since 2024.04.11
 */
public class Employee extends Person {

    private static int nextId;

    static {
        Random generator = new Random();
        nextId = generator.nextInt(1000);
    }

    private double salary;
    private LocalDate hireDay;
    private int id;

    {
        id = nextId;
        nextId++;
    }

    public Employee(String name, double salary, int year, int month, int day) {
        super(name);
        this.hireDay = LocalDate.of(year, month, day);
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

    @Override
    public String getDesignation() {
        return String.format("an employee with a salary of $%.2f", salary);
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

}
