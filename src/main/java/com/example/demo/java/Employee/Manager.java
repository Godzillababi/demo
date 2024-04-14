package com.example.demo.java.Employee;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

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

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        System.out.println(calendar.get(Calendar.YEAR));
        // MONTH 月，从0开始算起，最大11；0代表1月，11代表12月
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));
        System.out.println(calendar.get(Calendar.MILLISECOND));
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
}
