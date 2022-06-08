package com.additional_project.salary_calculator.controller;

import com.additional_project.salary_calculator.entity.ItemsToCalculate;
import com.additional_project.salary_calculator.entity.Ratio;
import com.additional_project.salary_calculator.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController("/")
public class CalculatorRestController {

    SalaryService salaryService;

    @Autowired
    public CalculatorRestController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }


    @PostMapping("/calculate")
    public ItemsToCalculate createProduct(@RequestBody ItemsToCalculate itemsToCalculate){
        int result = salaryService.calculate(itemsToCalculate);
        return itemsToCalculate;
    }

    @GetMapping("/salary")
    public double createProduct(){
        return salaryService.getSalary();
    }
}
