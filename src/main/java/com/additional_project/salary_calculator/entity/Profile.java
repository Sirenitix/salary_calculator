package com.additional_project.salary_calculator.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Profile {

    @Id
    private long id;
    private String name;
    private double salalry;

}

