package com.additional_project.salary_calculator.entity;

import lombok.*;

@Data
@ToString
public class ItemsToCalculateFull extends ItemsToCalculate {
    private Integer updateHour;
    private Integer homeHour;
    private Integer gymHour;
    private Integer deepHour;
    private String roomLook;
    private String classMentor;
    private Integer profHour;
    private Integer noteHour;
    private String noteType;
    private String nisProgram;
    private String qualityCategory;
    private String ecoZone;
    private String radZone;
    private String inEnglish;
    private boolean mentoring;
    private boolean masters;
}
