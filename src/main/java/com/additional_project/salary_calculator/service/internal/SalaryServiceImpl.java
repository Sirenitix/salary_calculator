package com.additional_project.salary_calculator.service.internal;

import com.additional_project.salary_calculator.entity.ItemsToCalculate;
import com.additional_project.salary_calculator.entity.Ratio;
import com.additional_project.salary_calculator.entity.User;
import com.additional_project.salary_calculator.repository.CustomUserRepository;
import com.additional_project.salary_calculator.repository.UserRepository;
import com.additional_project.salary_calculator.service.SalaryService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.additional_project.salary_calculator.entity.Ratio.*;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomUserRepository customUserRepository;

    @PostConstruct
    public void createMaps() {
        ratioMap = new HashMap<>();
        ratioMap.put(new Ratio(0,1), 4.67);
        ratioMap.put(new Ratio(1,1), 4.74);
        ratioMap.put(new Ratio(2,1), 4.81);
        ratioMap.put(new Ratio(3,1), 4.88);
        ratioMap.put(new Ratio(4,1), 4.88);
        ratioMap.put(new Ratio(5,1), 4.95);
        ratioMap.put(new Ratio(6,1), 4.95);
        ratioMap.put(new Ratio(7,1), 5.01);
        ratioMap.put(new Ratio(8,1), 5.01);
        ratioMap.put(new Ratio(9,1), 5.01);
        ratioMap.put(new Ratio(10,1), 5.08);
        ratioMap.put(new Ratio(11,1), 5.08);
        ratioMap.put(new Ratio(12,1), 5.08);
        ratioMap.put(new Ratio(13,1), 5.16);
        ratioMap.put(new Ratio(14,1), 5.16);
        ratioMap.put(new Ratio(15,1), 5.16);
        ratioMap.put(new Ratio(16,1), 5.24);
        ratioMap.put(new Ratio(17,1), 5.24);
        ratioMap.put(new Ratio(18,1), 5.24);
        ratioMap.put(new Ratio(19,1), 5.24);
        ratioMap.put(new Ratio(20,1), 5.32);
        ratioMap.put(new Ratio(21,1), 5.32);
        ratioMap.put(new Ratio(22,1), 5.32);
        ratioMap.put(new Ratio(23,1), 5.32);
        ratioMap.put(new Ratio(24,1), 5.32);
        ratioMap.put(new Ratio(25,1), 5.32);
        ratioMap.put(new Ratio(26,1), 5.41);


        ratioMap.put(new Ratio(0,2), 4.39);
        ratioMap.put(new Ratio(1,2), 4.50);
        ratioMap.put(new Ratio(2,2), 4.57);
        ratioMap.put(new Ratio(3,2), 4.65);
        ratioMap.put(new Ratio(4,2), 4.65);
        ratioMap.put(new Ratio(5,2), 4.72);
        ratioMap.put(new Ratio(6,2), 4.72);
        ratioMap.put(new Ratio(7,2), 4.79);
        ratioMap.put(new Ratio(8,2), 4.79);
        ratioMap.put(new Ratio(9,2), 4.79);
        ratioMap.put(new Ratio(10,2), 4.86);
        ratioMap.put(new Ratio(11,2), 4.86);
        ratioMap.put(new Ratio(12,2), 4.86);
        ratioMap.put(new Ratio(13,2), 4.95);
        ratioMap.put(new Ratio(14,2), 4.95);
        ratioMap.put(new Ratio(15,2), 4.95);
        ratioMap.put(new Ratio(16,2), 5.03);
        ratioMap.put(new Ratio(17,2), 5.03);
        ratioMap.put(new Ratio(18,2), 5.03);
        ratioMap.put(new Ratio(19,2), 5.03);
        ratioMap.put(new Ratio(20,2), 5.12);
        ratioMap.put(new Ratio(21,2), 5.12);
        ratioMap.put(new Ratio(22,2), 5.12);
        ratioMap.put(new Ratio(23,2), 5.12);
        ratioMap.put(new Ratio(24,2), 5.12);
        ratioMap.put(new Ratio(25,2), 5.12);
        ratioMap.put(new Ratio(26,2), 5.20);


        ratioMap.put(new Ratio(0,3), 4.36);
        ratioMap.put(new Ratio(1,3), 4.44);
        ratioMap.put(new Ratio(2,3), 4.51);
        ratioMap.put(new Ratio(3,3), 4.59);
        ratioMap.put(new Ratio(4,3), 4.59);
        ratioMap.put(new Ratio(5,3), 4.66);
        ratioMap.put(new Ratio(6,3), 4.66);
        ratioMap.put(new Ratio(7,3), 4.74);
        ratioMap.put(new Ratio(8,3), 4.74);
        ratioMap.put(new Ratio(9,3), 4.74);
        ratioMap.put(new Ratio(10,3), 4.81);
        ratioMap.put(new Ratio(11,3), 4.81);
        ratioMap.put(new Ratio(12,3), 4.81);
        ratioMap.put(new Ratio(13,3), 4.90);
        ratioMap.put(new Ratio(14,3), 4.90);
        ratioMap.put(new Ratio(15,3), 4.90);
        ratioMap.put(new Ratio(16,3), 4.99);
        ratioMap.put(new Ratio(17,3), 4.99);
        ratioMap.put(new Ratio(18,3), 4.99);
        ratioMap.put(new Ratio(19,3), 4.99);
        ratioMap.put(new Ratio(20,3), 5.08);
        ratioMap.put(new Ratio(21,3), 5.08);
        ratioMap.put(new Ratio(22,3), 5.08);
        ratioMap.put(new Ratio(23,3), 5.08);
        ratioMap.put(new Ratio(24,3), 5.08);
        ratioMap.put(new Ratio(25,3), 5.08);
        ratioMap.put(new Ratio(26,3), 5.16);


        ratioMap.put(new Ratio(0,4), 4.10);
        ratioMap.put(new Ratio(1,4), 4.14);
        ratioMap.put(new Ratio(2,4), 4.19);
        ratioMap.put(new Ratio(3,4), 4.23);
        ratioMap.put(new Ratio(4,4), 4.23);
        ratioMap.put(new Ratio(5,4), 4.27);
        ratioMap.put(new Ratio(6,4), 4.27);
        ratioMap.put(new Ratio(7,4), 4.33);
        ratioMap.put(new Ratio(8,4), 4.33);
        ratioMap.put(new Ratio(9,4), 4.33);
        ratioMap.put(new Ratio(10,4), 4.38);
        ratioMap.put(new Ratio(11,4), 4.38);
        ratioMap.put(new Ratio(12,4), 4.38);
        ratioMap.put(new Ratio(13,4), 4.49);
        ratioMap.put(new Ratio(14,4), 4.49);
        ratioMap.put(new Ratio(15,4), 4.49);
        ratioMap.put(new Ratio(16,4), 4.59);
        ratioMap.put(new Ratio(17,4), 4.59);
        ratioMap.put(new Ratio(18,4), 4.59);
        ratioMap.put(new Ratio(19,4), 4.59);
        ratioMap.put(new Ratio(20,4), 4.67);
        ratioMap.put(new Ratio(21,4), 4.67);
        ratioMap.put(new Ratio(22,4), 4.67);
        ratioMap.put(new Ratio(23,4), 4.67);
        ratioMap.put(new Ratio(24,4), 4.67);
        ratioMap.put(new Ratio(25,4), 4.67);
        ratioMap.put(new Ratio(26,4), 4.73);

        categoryMap = new HashMap<>();
        categoryMap.put("Без категории", 4);
        categoryMap.put("2 категория", 3);
        categoryMap.put("1 категория", 2);
        categoryMap.put("Высшая категория", 1);


        mrp = new HashMap<>();
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

    }


    public String getLogin(){
        String login = new String();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            login = authentication.getName();
        }
        return login;
    }

    @Override
    public double calculate(ItemsToCalculate itemsToCalculate) {

        Double salary = 0.0;
        Double result = 0.0;

        Double rate = ratioMap.get(new Ratio(itemsToCalculate.getExperience(), categoryMap.get(itemsToCalculate.getCategory())));
        salary = ((bdo * rate * 1.75)*itemsToCalculate.getLoad())/16;

        if(salary < mrp.get(itemsToCalculate.getDate().substring(0,itemsToCalculate.getDate().length()-3)) * 25){
            result = salary - (((salary * 0.1) - (salary * 0.02) - (mrp.get(itemsToCalculate.getDate().substring(0,itemsToCalculate.getDate().length()-3)) * 14)) * 0.01);
        }   else {
            result = salary - (((salary * 0.1) - (salary * 0.02) - (mrp.get(itemsToCalculate.getDate().substring(0,itemsToCalculate.getDate().length()-3)) * 14)) * 0.1);
        }

        if(itemsToCalculate.getCheckbox().equals("true")){
            result *= 1.25;
        }

        System.out.println((Math.round(result * 100.0) / 100.0));
        customUserRepository.updateUserSalary(getLogin(), (Math.round(result * 100.0) / 100.0));
        return (Math.round(result * 100.0) / 100.0);
    }

    @Override
    public double getSalary() {
       return userRepository.findByLogin(getLogin()).getSalary();
    }

}
