package com.additional_project.salary_calculator.service;

import com.additional_project.salary_calculator.entity.ItemsToCalculate;
import com.additional_project.salary_calculator.entity.ItemsToCalculateFull;
import org.springframework.stereotype.Service;

@Service
public interface SalaryService {
    double calculate(ItemsToCalculate itemsToCalculate);
    double getSalary();

    double minusTax(double salary, ItemsToCalculate itemsToCalculate);
    double calculationWithAdditionalParameters(ItemsToCalculateFull itemsToCalculateFull);
}
