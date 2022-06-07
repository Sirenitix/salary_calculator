package com.additional_project.salary_calculator.service;

import com.additional_project.salary_calculator.entity.Profile;
import org.springframework.stereotype.Service;

@Service
public interface SalaryService {
    int calculate();

    void createProfile(Profile profile);
}
