package com.additional_project.salary_calculator.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController("/")
public class CalculatorRestController {
    @PostMapping("/calculate")
    public ItemsToCalculate createProduct(@RequestBody ItemsToCalculate itemsToCalculate){
        return itemsToCalculate;
    }
}
