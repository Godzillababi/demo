package com.example.demo.java.Employee;

public class ParamTest {
    public static void main(String[] args) {

        System.out.println("Testing TripleValue");
        double percent = 10;
        System.out.println("Percent:1 " + percent);
        tripleValue(percent);
        System.out.println("Percent:3 " + percent);

        System.out.println("Testing TripleSalary");
        Employee employee = new Employee("jcy", 5000);
        System.out.println("salary:1 " + employee.getSalary());
        tripleSalary(employee);
        System.out.println("salary:3 " + employee.getSalary());

        System.out.println("Testing swap");
        Employee employee2 = new Employee("jcy", 5000);
        Employee employee3 = new Employee("cxy", 15000);
        System.out.println("employee2:1 " + employee2.getName());
        System.out.println("employee3:1 " + employee3.getName());
        swap(employee2, employee3);
        System.out.println("employee2:3 " + employee2.getName());
        System.out.println("employee3:3 " + employee3.getName());
    }

    private static void swap(Employee employee2, Employee employee3) {
        Employee temp = employee2;
        employee2 = employee3;
        employee3 = temp;
        System.out.println("employee2:2 " + employee2.getName());
        System.out.println("employee3:3 " + employee3.getName());
    }

    private static void tripleSalary(Employee employee) {
        employee.raiseSalary(10);
        System.out.println("salary:2 " + employee.getSalary());
    }

    private static void tripleValue(double percent) {
        percent = percent * 3;
        System.out.println("Percent:2 " + percent);
    }


}
