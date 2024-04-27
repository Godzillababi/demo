package com.example.enums;

import java.util.Scanner;

public class EnumTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the employee type (Manager/Developer/Tester): ");
        String employeeType = scanner.nextLine();
        EmployeeType type = EmployeeType.valueOf(employeeType);
        System.out.println("Employee type: " + type);
        System.out.println("abbreviation: " + type.getAbbreviation());
    }

    enum EmployeeType {
        Manager("M"), Developer("D"), Tester("T");
        private String abbreviation;

        EmployeeType(String abbreviation) {
            this.abbreviation = abbreviation;
        }

        public String getAbbreviation() {
            return abbreviation;
        }
    }
}
