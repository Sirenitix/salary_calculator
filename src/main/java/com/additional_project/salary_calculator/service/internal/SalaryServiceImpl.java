package com.additional_project.salary_calculator.service.internal;

import com.additional_project.salary_calculator.entity.ItemsToCalculate;
import com.additional_project.salary_calculator.entity.Ratio;
import com.additional_project.salary_calculator.entity.User;
import com.additional_project.salary_calculator.repository.CustomUserRepository;
import com.additional_project.salary_calculator.repository.UserRepository;
import com.additional_project.salary_calculator.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomUserRepository customUserRepository;

    private Map<Ratio, Double> ratio = new HashMap<>();

    @PostConstruct
    public void createMap() {
        ratio.put(new Ratio(0,1), 4.67);
        ratio.put(new Ratio(1,1), 4.74);
        ratio.put(new Ratio(2,1), 4.81);
        ratio.put(new Ratio(3,1), 4.88);
        ratio.put(new Ratio(4,1), 4.88);
        ratio.put(new Ratio(5,1), 4.95);
        ratio.put(new Ratio(6,1), 4.95);
        ratio.put(new Ratio(7,1), 5.01);
        ratio.put(new Ratio(8,1), 5.01);
        ratio.put(new Ratio(9,1), 5.01);
        ratio.put(new Ratio(10,1), 5.08);
        ratio.put(new Ratio(11,1), 5.08);
        ratio.put(new Ratio(12,1), 5.08);
        ratio.put(new Ratio(13,1), 5.16);
        ratio.put(new Ratio(13,1), 5.16);

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
    public int calculate(ItemsToCalculate itemsToCalculate) {
        customUserRepository.updateUserSalary(getLogin(), 100);
        return 0;
    }

    @Override
    public double getSalary() {
       return userRepository.findByLogin(getLogin()).getSalary();
    }

}
