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

    public static Map<Ratio, Double> ratioMapHigh;

    public static Map<Ratio, Double> ratioMapLow;
    public static Map<String, Integer> categoryMap;

    public static Map<String, Map<Ratio, Double>> educationLevelMap;

    public static final int bdo = 17697;

    public static Map<String , Integer> mrp;

    public static Map<String , Double> classTypes;

    public static Map<String , Double> roomWatcherTypes;

    public static Map<String , Double> radLevels;

    public static Map<String , Double> ecoLevels;

    public static Map<String , Double> qualificationTypes;

    public static Map<String , Double> nisLevels;

    public static Map<String , Integer> engDiveLevel;

    public static Map<String, Double> noteTypes;

    public static Map<Integer, Double> yearPercentage;

    static {


        categoryMap = new HashMap<>();
        categoryMap.put("Без категории", 4);
        categoryMap.put("2 категория", 3);
        categoryMap.put("1 категория", 2);
        categoryMap.put("Высшая категория", 1);


        mrp = new HashMap<>();
        mrp.put("2023", 3201);
        mrp.put("2022", 3180);
        mrp.put("2021", 2917);
        mrp.put("2020", 2778);
        mrp.put("2019", 2525);
        mrp.put("2018", 2405);
        mrp.put("2017", 2269);
        mrp.put("2016", 2121);
        mrp.put("2015", 1982);
        mrp.put("2014", 1852);
        mrp.put("2013", 1731);
        mrp.put("2012", 1618);
        mrp.put("2011", 1512);
        mrp.put("2010", 1413);
        mrp.put("2009", 1273);
        mrp.put("2008", 1168);
        mrp.put("2007", 1092);
        mrp.put("2006", 1030);
        mrp.put("2005", 971);
        mrp.put("2004", 919);
        mrp.put("2003", 872);
        mrp.put("2002", 823);
        mrp.put("2001", 775);
        mrp.put("2000", 725);


        ratioMapLow = new HashMap<>();
        ratioMapLow.put(new Ratio(0,1), 3.95);
        ratioMapLow.put(new Ratio(1,1), 3.99);
        ratioMapLow.put(new Ratio(2,1), 4.05);
        ratioMapLow.put(new Ratio(3,1), 4.11);
        ratioMapLow.put(new Ratio(4,1), 4.11);
        ratioMapLow.put(new Ratio(5,1), 4.16);
        ratioMapLow.put(new Ratio(6,1), 4.16);
        ratioMapLow.put(new Ratio(7,1), 4.22);
        ratioMapLow.put(new Ratio(8,1), 4.22);
        ratioMapLow.put(new Ratio(9,1), 4.22);
        ratioMapLow.put(new Ratio(10,1), 4.28);
        ratioMapLow.put(new Ratio(11,1), 4.28);
        ratioMapLow.put(new Ratio(12,1), 4.28);
        ratioMapLow.put(new Ratio(13,1), 4.34);
        ratioMapLow.put(new Ratio(14,1), 4.34);
        ratioMapLow.put(new Ratio(15,1), 4.34);
        ratioMapLow.put(new Ratio(16,1), 4.40);
        ratioMapLow.put(new Ratio(17,1), 4.40);
        ratioMapLow.put(new Ratio(18,1), 4.40);
        ratioMapLow.put(new Ratio(19,1), 4.40);
        ratioMapLow.put(new Ratio(20,1), 4.45);
        ratioMapLow.put(new Ratio(21,1), 4.45);
        ratioMapLow.put(new Ratio(22,1), 4.45);
        ratioMapLow.put(new Ratio(23,1), 4.45);
        ratioMapLow.put(new Ratio(24,1), 4.45);
        ratioMapLow.put(new Ratio(25,1), 4.45);
        ratioMapLow.put(new Ratio(26,1), 4.52);


        ratioMapLow.put(new Ratio(0,2), 3.73);
        ratioMapLow.put(new Ratio(1,2), 3.79);
        ratioMapLow.put(new Ratio(2,2), 3.85);
        ratioMapLow.put(new Ratio(3,2), 3.92);
        ratioMapLow.put(new Ratio(4,2), 3.92);
        ratioMapLow.put(new Ratio(5,2), 3.97);
        ratioMapLow.put(new Ratio(6,2), 3.97);
        ratioMapLow.put(new Ratio(7,2), 4.04);
        ratioMapLow.put(new Ratio(8,2), 4.04);
        ratioMapLow.put(new Ratio(9,2), 4.04);
        ratioMapLow.put(new Ratio(10,2), 4.10);
        ratioMapLow.put(new Ratio(11,2), 4.10);
        ratioMapLow.put(new Ratio(12,2), 4.10);
        ratioMapLow.put(new Ratio(13,2), 4.17);
        ratioMapLow.put(new Ratio(14,2), 4.17);
        ratioMapLow.put(new Ratio(15,2), 4.17);
        ratioMapLow.put(new Ratio(16,2), 4.25);
        ratioMapLow.put(new Ratio(17,2), 4.25);
        ratioMapLow.put(new Ratio(18,2), 4.25);
        ratioMapLow.put(new Ratio(19,2), 5.03);
        ratioMapLow.put(new Ratio(20,2), 4.32);
        ratioMapLow.put(new Ratio(21,2), 4.32);
        ratioMapLow.put(new Ratio(22,2), 4.32);
        ratioMapLow.put(new Ratio(23,2), 4.32);
        ratioMapLow.put(new Ratio(24,2), 4.32);
        ratioMapLow.put(new Ratio(25,2), 4.32);
        ratioMapLow.put(new Ratio(26,2), 4.39);


        ratioMapLow.put(new Ratio(0,3), 3.67);
        ratioMapLow.put(new Ratio(1,3), 3.73);
        ratioMapLow.put(new Ratio(2,3), 3.79);
        ratioMapLow.put(new Ratio(3,3), 3.85);
        ratioMapLow.put(new Ratio(4,3), 3.85);
        ratioMapLow.put(new Ratio(5,3), 3.91);
        ratioMapLow.put(new Ratio(6,3), 3.91);
        ratioMapLow.put(new Ratio(7,3), 3.97);
        ratioMapLow.put(new Ratio(8,3), 3.97);
        ratioMapLow.put(new Ratio(9,3), 3.97);
        ratioMapLow.put(new Ratio(10,3), 4.03);
        ratioMapLow.put(new Ratio(11,3), 4.03);
        ratioMapLow.put(new Ratio(12,3), 4.03);
        ratioMapLow.put(new Ratio(13,3), 4.09);
        ratioMapLow.put(new Ratio(14,3), 4.09);
        ratioMapLow.put(new Ratio(15,3), 4.09);
        ratioMapLow.put(new Ratio(16,3), 4.16);
        ratioMapLow.put(new Ratio(17,3), 4.16);
        ratioMapLow.put(new Ratio(18,3), 4.16);
        ratioMapLow.put(new Ratio(19,3), 4.16);
        ratioMapLow.put(new Ratio(20,3), 4.22);
        ratioMapLow.put(new Ratio(21,3), 4.22);
        ratioMapLow.put(new Ratio(22,3), 4.22);
        ratioMapLow.put(new Ratio(23,3), 4.22);
        ratioMapLow.put(new Ratio(24,3), 4.22);
        ratioMapLow.put(new Ratio(25,3), 4.22);
        ratioMapLow.put(new Ratio(26,3), 4.29);


        ratioMapLow.put(new Ratio(0,4), 3.32);
        ratioMapLow.put(new Ratio(1,4), 3.36);
        ratioMapLow.put(new Ratio(2,4), 3.41);
        ratioMapLow.put(new Ratio(3,4), 3.45);
        ratioMapLow.put(new Ratio(4,4), 3.45);
        ratioMapLow.put(new Ratio(5,4), 3.49);
        ratioMapLow.put(new Ratio(6,4), 3.49);
        ratioMapLow.put(new Ratio(7,4), 3.53);
        ratioMapLow.put(new Ratio(8,4), 3.53);
        ratioMapLow.put(new Ratio(9,4), 3.53);
        ratioMapLow.put(new Ratio(10,4), 3.57);
        ratioMapLow.put(new Ratio(11,4), 3.57);
        ratioMapLow.put(new Ratio(12,4), 3.57);
        ratioMapLow.put(new Ratio(13,4), 3.61);
        ratioMapLow.put(new Ratio(14,4), 3.61);
        ratioMapLow.put(new Ratio(15,4), 3.61);
        ratioMapLow.put(new Ratio(16,4), 3.65);
        ratioMapLow.put(new Ratio(17,4), 3.65);
        ratioMapLow.put(new Ratio(18,4), 3.65);
        ratioMapLow.put(new Ratio(19,4), 3.65);
        ratioMapLow.put(new Ratio(20,4), 3.69);
        ratioMapLow.put(new Ratio(21,4), 3.69);
        ratioMapLow.put(new Ratio(22,4), 3.69);
        ratioMapLow.put(new Ratio(23,4), 3.69);
        ratioMapLow.put(new Ratio(24,4), 3.69);
        ratioMapLow.put(new Ratio(25,4), 3.69);
        ratioMapLow.put(new Ratio(26,4), 3.73);


        ratioMapHigh = new HashMap<>();
        ratioMapHigh.put(new Ratio(0,1), 4.67);
        ratioMapHigh.put(new Ratio(1,1), 4.74);
        ratioMapHigh.put(new Ratio(2,1), 4.81);
        ratioMapHigh.put(new Ratio(3,1), 4.88);
        ratioMapHigh.put(new Ratio(4,1), 4.88);
        ratioMapHigh.put(new Ratio(5,1), 4.95);
        ratioMapHigh.put(new Ratio(6,1), 4.95);
        ratioMapHigh.put(new Ratio(7,1), 5.01);
        ratioMapHigh.put(new Ratio(8,1), 5.01);
        ratioMapHigh.put(new Ratio(9,1), 5.01);
        ratioMapHigh.put(new Ratio(10,1), 5.08);
        ratioMapHigh.put(new Ratio(11,1), 5.08);
        ratioMapHigh.put(new Ratio(12,1), 5.08);
        ratioMapHigh.put(new Ratio(13,1), 5.16);
        ratioMapHigh.put(new Ratio(14,1), 5.16);
        ratioMapHigh.put(new Ratio(15,1), 5.16);
        ratioMapHigh.put(new Ratio(16,1), 5.24);
        ratioMapHigh.put(new Ratio(17,1), 5.24);
        ratioMapHigh.put(new Ratio(18,1), 5.24);
        ratioMapHigh.put(new Ratio(19,1), 5.24);
        ratioMapHigh.put(new Ratio(20,1), 5.32);
        ratioMapHigh.put(new Ratio(21,1), 5.32);
        ratioMapHigh.put(new Ratio(22,1), 5.32);
        ratioMapHigh.put(new Ratio(23,1), 5.32);
        ratioMapHigh.put(new Ratio(24,1), 5.32);
        ratioMapHigh.put(new Ratio(25,1), 5.32);
        ratioMapHigh.put(new Ratio(26,1), 5.41);


        ratioMapHigh.put(new Ratio(0,2), 4.39);
        ratioMapHigh.put(new Ratio(1,2), 4.50);
        ratioMapHigh.put(new Ratio(2,2), 4.57);
        ratioMapHigh.put(new Ratio(3,2), 4.65);
        ratioMapHigh.put(new Ratio(4,2), 4.65);
        ratioMapHigh.put(new Ratio(5,2), 4.72);
        ratioMapHigh.put(new Ratio(6,2), 4.72);
        ratioMapHigh.put(new Ratio(7,2), 4.79);
        ratioMapHigh.put(new Ratio(8,2), 4.79);
        ratioMapHigh.put(new Ratio(9,2), 4.79);
        ratioMapHigh.put(new Ratio(10,2), 4.86);
        ratioMapHigh.put(new Ratio(11,2), 4.86);
        ratioMapHigh.put(new Ratio(12,2), 4.86);
        ratioMapHigh.put(new Ratio(13,2), 4.95);
        ratioMapHigh.put(new Ratio(14,2), 4.95);
        ratioMapHigh.put(new Ratio(15,2), 4.95);
        ratioMapHigh.put(new Ratio(16,2), 5.03);
        ratioMapHigh.put(new Ratio(17,2), 5.03);
        ratioMapHigh.put(new Ratio(18,2), 5.03);
        ratioMapHigh.put(new Ratio(19,2), 5.03);
        ratioMapHigh.put(new Ratio(20,2), 5.12);
        ratioMapHigh.put(new Ratio(21,2), 5.12);
        ratioMapHigh.put(new Ratio(22,2), 5.12);
        ratioMapHigh.put(new Ratio(23,2), 5.12);
        ratioMapHigh.put(new Ratio(24,2), 5.12);
        ratioMapHigh.put(new Ratio(25,2), 5.12);
        ratioMapHigh.put(new Ratio(26,2), 5.20);


        ratioMapHigh.put(new Ratio(0,3), 4.36);
        ratioMapHigh.put(new Ratio(1,3), 4.44);
        ratioMapHigh.put(new Ratio(2,3), 4.51);
        ratioMapHigh.put(new Ratio(3,3), 4.59);
        ratioMapHigh.put(new Ratio(4,3), 4.59);
        ratioMapHigh.put(new Ratio(5,3), 4.66);
        ratioMapHigh.put(new Ratio(6,3), 4.66);
        ratioMapHigh.put(new Ratio(7,3), 4.74);
        ratioMapHigh.put(new Ratio(8,3), 4.74);
        ratioMapHigh.put(new Ratio(9,3), 4.74);
        ratioMapHigh.put(new Ratio(10,3), 4.81);
        ratioMapHigh.put(new Ratio(11,3), 4.81);
        ratioMapHigh.put(new Ratio(12,3), 4.81);
        ratioMapHigh.put(new Ratio(13,3), 4.90);
        ratioMapHigh.put(new Ratio(14,3), 4.90);
        ratioMapHigh.put(new Ratio(15,3), 4.90);
        ratioMapHigh.put(new Ratio(16,3), 4.99);
        ratioMapHigh.put(new Ratio(17,3), 4.99);
        ratioMapHigh.put(new Ratio(18,3), 4.99);
        ratioMapHigh.put(new Ratio(19,3), 4.99);
        ratioMapHigh.put(new Ratio(20,3), 5.08);
        ratioMapHigh.put(new Ratio(21,3), 5.08);
        ratioMapHigh.put(new Ratio(22,3), 5.08);
        ratioMapHigh.put(new Ratio(23,3), 5.08);
        ratioMapHigh.put(new Ratio(24,3), 5.08);
        ratioMapHigh.put(new Ratio(25,3), 5.08);
        ratioMapHigh.put(new Ratio(26,3), 5.16);


        ratioMapHigh.put(new Ratio(0,4), 4.10);
        ratioMapHigh.put(new Ratio(1,4), 4.14);
        ratioMapHigh.put(new Ratio(2,4), 4.19);
        ratioMapHigh.put(new Ratio(3,4), 4.23);
        ratioMapHigh.put(new Ratio(4,4), 4.23);
        ratioMapHigh.put(new Ratio(5,4), 4.27);
        ratioMapHigh.put(new Ratio(6,4), 4.27);
        ratioMapHigh.put(new Ratio(7,4), 4.33);
        ratioMapHigh.put(new Ratio(8,4), 4.33);
        ratioMapHigh.put(new Ratio(9,4), 4.33);
        ratioMapHigh.put(new Ratio(10,4), 4.38);
        ratioMapHigh.put(new Ratio(11,4), 4.38);
        ratioMapHigh.put(new Ratio(12,4), 4.38);
        ratioMapHigh.put(new Ratio(13,4), 4.49);
        ratioMapHigh.put(new Ratio(14,4), 4.49);
        ratioMapHigh.put(new Ratio(15,4), 4.49);
        ratioMapHigh.put(new Ratio(16,4), 4.59);
        ratioMapHigh.put(new Ratio(17,4), 4.59);
        ratioMapHigh.put(new Ratio(18,4), 4.59);
        ratioMapHigh.put(new Ratio(19,4), 4.59);
        ratioMapHigh.put(new Ratio(20,4), 4.67);
        ratioMapHigh.put(new Ratio(21,4), 4.67);
        ratioMapHigh.put(new Ratio(22,4), 4.67);
        ratioMapHigh.put(new Ratio(23,4), 4.67);
        ratioMapHigh.put(new Ratio(24,4), 4.67);
        ratioMapHigh.put(new Ratio(25,4), 4.67);
        ratioMapHigh.put(new Ratio(26,4), 4.73);


        educationLevelMap = new HashMap<>();
        educationLevelMap.put("Высшее", ratioMapHigh);
        educationLevelMap.put("Среднее специальное", ratioMapLow);

        classTypes = new HashMap<>();
        classTypes.put("1-4 классы полный", bdo * 0.4);
        classTypes.put("1-4 классы неполный", (bdo * 0.4) / 2);
        classTypes.put("5-11 классы полный", bdo * 0.6);
        classTypes.put("5-11 классы неполный", (bdo * 0.6) / 2);

        roomWatcherTypes = new HashMap<>();
        roomWatcherTypes.put("Весь день", bdo * 0.2);
        roomWatcherTypes.put("Пол дня", bdo * 0.1);
        roomWatcherTypes.put("Мастерской весь день", bdo * 0.3);
        roomWatcherTypes.put("Мастерской пол дня", bdo * 0.15);


        radLevels = new HashMap<>();
        radLevels.put("Чрезвычайный риск", 2.0);
        radLevels.put("Максимальный кризиса", 1.75);
        radLevels.put("Повышенный", 1.5);
        radLevels.put("Минимальный", 1.25);
        radLevels.put("С льготным социально экономическим статусом", 1.0);


        ecoLevels = new HashMap<>();
        ecoLevels.put("Экологической катастрофы", 0.5);
        ecoLevels.put("Экологического кризиса", 0.3);
        ecoLevels.put("Экологического пред кризисного состояния", 0.2);


        qualificationTypes = new HashMap<>();
        qualificationTypes.put("Педагог-мастер", 0.5);
        qualificationTypes.put("Педагог-исследователь", 0.4);
        qualificationTypes.put("Педагог-эксперт", 0.35);
        qualificationTypes.put("Педагог-модератор", 0.3);


        nisLevels = new HashMap<>();
        nisLevels.put("1 уровень", 1.0);
        nisLevels.put("2 уровень", 0.7);
        nisLevels.put("3 уровень", 0.3);

        engDiveLevel = new HashMap<>();
        engDiveLevel.put("Полное погружение", 2 * bdo);
        engDiveLevel.put("Частичное погружение", bdo);

        noteTypes = new HashMap<>();
        noteTypes.put("Учитель ЕМН", 0.4 * bdo);
        noteTypes.put("Учитель 1-4 классов", (bdo / 16) * 0.4);
        noteTypes.put("Учителя языка и литературы", (bdo / 16) * 0.5);


        yearPercentage = new HashMap<>();
        yearPercentage.put(2023, 2.0);
        yearPercentage.put(2022, 1.75);
        yearPercentage.put(2021, 1.5);
        yearPercentage.put(2020, 1.25);
        yearPercentage.put(2019, 1.0);
    }

}





