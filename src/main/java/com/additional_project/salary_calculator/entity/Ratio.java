package com.additional_project.salary_calculator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class Ratio {
    public int yearCount;
    public int degree;

    public static Map<Ratio, Double> ratioMap;
    public static Map<String, Integer> categoryMap;

    public static final int bdo = 17697;

    public static Map<String , Integer> mrp;



}

