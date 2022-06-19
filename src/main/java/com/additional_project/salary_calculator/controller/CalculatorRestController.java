package com.additional_project.salary_calculator.controller;

import com.additional_project.salary_calculator.entity.ItemsToCalculate;
import com.additional_project.salary_calculator.entity.ItemsToCalculateFull;
import com.additional_project.salary_calculator.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController("/")
public class CalculatorRestController {

    @Autowired
    SalaryService salaryService;


    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public double calculate(@RequestBody ItemsToCalculate itemsToCalculate){
        return salaryService.calculate(itemsToCalculate);
    }

    @RequestMapping(value = "/additional", method = RequestMethod.POST)
    public double calculateFull(@RequestBody ItemsToCalculateFull itemsToCalculateFull){
        return salaryService.calculationWithAdditionalParameters(itemsToCalculateFull);
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error(){
        return "0";
    }


    @RequestMapping(value = "/salary", method = RequestMethod.GET)
    public double getSalary(){
        return salaryService.getSalary();
    }
}
