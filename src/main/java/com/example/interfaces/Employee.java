package com.example.interfaces;

/**
 * 员工对象类
 *
 * @author jcy
 * @since 2024.04.28
 */
public class Employee implements Comparable<Employee>, Cloneable {

    String name = "";
    double salary;

    public Employee(String name, double salary) {
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


    @Override
    public int compareTo(Employee o) {
        return Double.compare(this.salary, o.salary);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
