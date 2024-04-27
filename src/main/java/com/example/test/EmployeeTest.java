package com.example.test;

import com.example.bean.Employee;
import com.example.bean.Executive;
import com.example.bean.Manager;

import java.time.LocalDate;

public class EmployeeTest {
    public static void main(String[] args) {

        Employee[] employees = new Employee[5];
        employees[0] = new Employee("jcy", 13500, 1995, 5, 20);
        employees[1] = new Employee("cxy", 5600, 1995, 7, 30);
        employees[2] = new Employee("gqp", 12000, 1993, 12, 24);

        Manager manager = new Manager("qgy", LocalDate.now(), 15000, 10000);
        // 多态
        employees[3] = manager;

        Executive executive = new Executive("ysf", LocalDate.now(), 20000, 20000);
        employees[4] = executive;

        for (Employee employee : employees) {
            employee.raiseSalary(30);
        }

        for (Employee employee : employees) {
            // getSalary() 动态绑定，输出了 manager 的 getSalary()方法
            System.out.println("id: " + employee.getId() + "， name: " + employee.getName() + ", salary: " + employee.getSalary() + " hirDay: " +
                    employee.getHireDay());
        }


    }
}
