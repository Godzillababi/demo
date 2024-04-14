package com.example.demo.java.Employee;

import static java.lang.System.out;

/**
 * 构造器初始化顺序：
 * <br/>0、默认初始化，数值1，boolean类型false，对象null
 * <br/>1、static静态方法初始化。
 * <br/>2、声明初始化。
 * <br/>3、初始化代码块。
 * <br/>4、构造器初始化。
 *
 * @author jcy
 * @since 2024-04-13
 */
public class ConstructorTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Jcy", 20000);
        staff[1] = new Employee("cxy");
        staff[2] = new Employee();

        for (Employee e : staff) {
            out.println("name: " + e.getName() + ", salary: " + e.getSalary() + ", id: " + e.getId());
        }
    }
}
