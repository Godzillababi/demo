package com.example.demo.java.Employee.equals;

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

    private String name = "";
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, int year, int month, int day) {
        this.hireDay = LocalDate.of(year, month, day);
        this.name = name;
        this.salary = salary;
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
        return Objects.equals(this.name, employee.name) &&
                Objects.equals(this.salary, employee.salary) && Objects.equals(this.hireDay, employee.hireDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.salary, this.hireDay);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + name + ", " + salary + ", " + hireDay + "}";          // ;
    }
}
