package com.additional_project.salary_calculator.controller;

import com.additional_project.salary_calculator.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SalaryController {
    SalaryService salaryService;

    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping("/")
    public String salaryRequest(){
        return "main.html";
    }

}
