package com.additional_project.salary_calculator.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface CustomUserRepository {
    void updateUserSalary(String name, double salary);
}
