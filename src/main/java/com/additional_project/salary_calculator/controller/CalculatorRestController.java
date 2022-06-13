package com.additional_project.salary_calculator.controller;

import com.additional_project.salary_calculator.entity.ItemsToCalculate;
import com.additional_project.salary_calculator.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController("/")
public class CalculatorRestController {

    @Autowired
    SalaryService salaryService;


    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public double createProduct(@RequestBody ItemsToCalculate itemsToCalculate){
        double result = salaryService.calculate(itemsToCalculate);
        return result;
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public double error(){
        return 0;
    }


    @RequestMapping(value = "/salary", method = RequestMethod.GET)
    public double createProduct(){
        return salaryService.getSalary();
    }
}
