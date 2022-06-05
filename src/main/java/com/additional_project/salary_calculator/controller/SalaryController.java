package com.additional_project.salary_calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SalaryController {

    @GetMapping("/")
    public String salaryRequest(){
        return "main.html";
    }

}
