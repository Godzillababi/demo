package com.example.demo.java.Employee.bean;

import java.time.LocalDate;

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary) {
        // 调用超类中构造器参数为name，salary 的方法
        super(name, salary);
        bonus = 0;
    }

    public Manager(String firstName, LocalDate birthDay, double salary, double bonus) {
        this.setName(firstName);
        this.setBonus(bonus);
        this.setSalary(salary);
        this.setHireDay(birthDay);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject)) {
            return false;
        }
        Manager other = (Manager) otherObject;
        if (Double.doubleToLongBits(this.bonus) != Double.doubleToLongBits(other.bonus)) {
            return false;
        }
        return true;
    }
}
