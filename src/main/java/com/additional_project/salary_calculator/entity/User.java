package com.additional_project.salary_calculator.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class User {

    private String login;
    private String password;
    private String role;
    private Boolean enabled;
    private Double salary;

}
