package com.example.demo.java.Employee;

import java.time.LocalDate;

public final class Executive extends Manager {

    public Executive(String name, double salary) {
        super(name, salary);
    }

    public Executive(String firstName, LocalDate birthDay, double salary, double bonus) {
        super(firstName, birthDay, salary, bonus);
    }

    @Override
    public String getName() {
        return "总经理：" + super.getName();
    }
}
