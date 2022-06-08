package com.additional_project.salary_calculator.controller;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class ItemsToCalculate {
    private String category;
    private String title;
    private String education;
    private String experience;
    private String date;
    private String weight;

}
