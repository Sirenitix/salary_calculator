package com.additional_project.salary_calculator.controller;

import com.additional_project.salary_calculator.entity.ItemsToCalculate;
import com.additional_project.salary_calculator.entity.Ratio;
import com.additional_project.salary_calculator.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController("/")
public class CalculatorRestController {

    SalaryService salaryService;

    @Autowired
    public CalculatorRestController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }


    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public ItemsToCalculate createProduct(@RequestBody ItemsToCalculate itemsToCalculate){
        double result = salaryService.calculate(itemsToCalculate);
        return itemsToCalculate;
    }


    @RequestMapping(value = "/salary", method = RequestMethod.GET)
    public double createProduct(){
        return salaryService.getSalary();
    }
}
