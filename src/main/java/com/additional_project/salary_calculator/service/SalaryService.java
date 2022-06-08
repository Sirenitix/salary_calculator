package com.additional_project.salary_calculator.service;

import com.additional_project.salary_calculator.entity.ItemsToCalculate;
import org.springframework.stereotype.Service;

@Service
public interface SalaryService {
    int calculate(ItemsToCalculate itemsToCalculate);
    double getSalary();
}
