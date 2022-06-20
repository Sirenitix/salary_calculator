package com.additional_project.salary_calculator.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ItemsToCalculate {
    private String category;
    private String title;
    private String education;
    private Integer experience;
    private String date;
    private Integer loads;
    private Boolean checkbox;
    private Boolean special;

}
