package com.example.equals;

public class EqualsTest {
    public static void main(String[] args) {
        Employee e1 = new Employee("jcy", 50000, 1995, 05, 20);
        Employee e2 = e1;
        Employee e3 = new Employee("jcy", 50000, 1995, 05, 20);
        Employee e4 = new Employee("cxy", 50000, 1995, 05, 20);

        System.out.print("e1:" + e1); // 调用toString方法
        System.out.print(" e1.hashCode():" + e1.hashCode());
        System.out.println(" e4.hashCode():" + e4.hashCode());
        System.out.println(e1 == (e2));
        System.out.println(e1 == (e3));
        System.out.println(e1.equals(e3));
        System.out.println(e1.equals(e4));

        Manager m1 = new Manager("jcy", 50000, 1995, 05, 20);
        Manager m2 = new Manager("jcy", 50000, 1995, 05, 20);
        m2.setBonus(10000);
        System.out.println(m1.equals(m2));
        System.out.println(m1.toString()); // 调用toString方法
        System.out.println(m2.hashCode());
    }
}


