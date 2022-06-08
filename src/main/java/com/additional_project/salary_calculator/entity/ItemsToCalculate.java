package com.additional_project.salary_calculator.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class ItemsToCalculate {
    private String category;
    private String title;
    private String education;
    private Integer experience;
    private String date;
    private Integer load;
    private String checkbox;

}
