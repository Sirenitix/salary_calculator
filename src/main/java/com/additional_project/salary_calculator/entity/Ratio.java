package com.additional_project.salary_calculator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Map;

@Data
@AllArgsConstructor
public class Ratio {
    public int yearCount;
    public int degree;

    public static Map<Ratio, Double> ratioMapHigh;

    public static Map<Ratio, Double> ratioMapLow;
    public static Map<String, Integer> categoryMap;

    public static Map<String, Map<Ratio, Double>> educationLevelMap;
    public static final int bdo = 17697;

    public static Map<String , Integer> mrp;



}





