package com.additional_project.salary_calculator.service.internal;

import com.additional_project.salary_calculator.entity.ItemsToCalculate;
import com.additional_project.salary_calculator.entity.ItemsToCalculateFull;
import com.additional_project.salary_calculator.entity.Ratio;
import com.additional_project.salary_calculator.repository.CustomUserRepository;
import com.additional_project.salary_calculator.repository.UserRepository;
import com.additional_project.salary_calculator.service.SalaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.Predicate;

import static com.additional_project.salary_calculator.entity.Ratio.*;

@Slf4j
@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomUserRepository customUserRepository;


    public String getLogin(){
        String login = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            login = authentication.getName();
        }
        return login;
    }



    @Override
    public double calculate(ItemsToCalculate itemsToCalculate) {

        double salary;
        double specialPay = 0;
        double primal = 0;

        double cef = yearPercentage.get(Integer.parseInt(itemsToCalculate.getDate().substring(0,itemsToCalculate.getDate().length()-3)));
        log.info("cef - " + cef);

        if(itemsToCalculate.getExperience() > 25){
            itemsToCalculate.setExperience(26);
        }

        if(itemsToCalculate.getExperience() > 25){
            itemsToCalculate.setExperience(26);
        }

        Double rate = educationLevelMap.get(itemsToCalculate.getEducation()).get(new Ratio(itemsToCalculate.getExperience(), categoryMap.get(itemsToCalculate.getCategory())));


        if(itemsToCalculate.getCheckbox()){
            primal = (((bdo * rate * cef) * 0.25));
        }

        if(itemsToCalculate.getSpecial()){
            specialPay  = (((bdo * rate * cef) + primal ) * 0.1);
        }


        salary = ((((bdo * rate * cef) + primal )*itemsToCalculate.getLoads())/16) + specialPay;


        log.info(bdo + " - БДО");
        log.info((bdo * rate * cef) + primal + " - ДО");
        log.info(rate + " - Koэффицент");
        log.info(salary + " - ЗП");
        log.info(mrp.get(itemsToCalculate.getDate().substring(0,itemsToCalculate.getDate().length()-3)) * 25 + " - 25 мрп");
        customUserRepository.updateUserSalary(getLogin(), (Math.round(salary * 100.0) / 100.0));
        return (Math.round(salary * 100.0) / 100.0) == 0 ? 0 : (Math.round(salary * 100.0) / 100.0);
    }

    @Override
    public double getSalary() {
       return userRepository.findByLogin(getLogin()).getSalary();
    }

    @Override
    public double minusTax(double salary, ItemsToCalculate itemsToCalculate) {
        double osms = salary * 0.02;
        double opv = salary * 0.1;
        double ipn = 0;

        if(salary < mrp.get(itemsToCalculate.getDate().substring(0,itemsToCalculate.getDate().length()-3)) * 25){
            ipn = ((salary - opv - osms - (mrp.get(itemsToCalculate.getDate().substring(0,itemsToCalculate.getDate().length()-3)) * 14)) * 0.01);
            log.info(ipn + " - ipn1111");
        }   else {
            ipn = ((salary - opv - osms - (mrp.get(itemsToCalculate.getDate().substring(0, itemsToCalculate.getDate().length() - 3)) * 14)) * 0.1);
            log.info(mrp.get(itemsToCalculate.getDate().substring(0, itemsToCalculate.getDate().length() - 3)) * 14 + " - 14 mrp");
            log.info(ipn + " - ipn2222");
        }
        double result = salary - osms - opv - ipn;
        return (Math.round(result * 100.0) / 100.0) == 0 ? 0 : (Math.round(result * 100.0) / 100.0);
    }

    @Override
    public double calculationWithAdditionalParameters(ItemsToCalculateFull itemsToCalculateFull) {
        double primal = 0;
        double cef = yearPercentage.get(Integer.parseInt(itemsToCalculateFull.getDate().substring(0,itemsToCalculateFull.getDate().length()-3)));
        Double rate = educationLevelMap.get(itemsToCalculateFull.getEducation()).get(new Ratio(itemsToCalculateFull.getExperience(), categoryMap.get(itemsToCalculateFull.getCategory())));
        if(itemsToCalculateFull.getCheckbox()){
            primal = (((bdo * rate * cef) * 0.25));
        }
        Double doOkl = bdo * rate * cef + primal;
        double localMrp = mrp.get(itemsToCalculateFull.getDate().substring(0,itemsToCalculateFull.getDate().length()-3));

        double result = calculate(itemsToCalculateFull);

        if(itemsToCalculateFull.isMentoring()){
            result = bdo + result;
        }

        if(itemsToCalculateFull.isMasters()){
            result = ((localMrp * 10) + result);
        }

        if(classTypes.containsKey(itemsToCalculateFull.getNoteType())){
            result = result + classTypes.get(itemsToCalculateFull.getNoteType());
        }

        if(roomWatcherTypes.containsKey(itemsToCalculateFull.getRoomLook())){
            result =  result + roomWatcherTypes.get(itemsToCalculateFull.getRoomLook());
        }

        if(radLevels.containsKey(itemsToCalculateFull.getRadZone())){
            result = result + (localMrp * radLevels.get(itemsToCalculateFull.getRadZone()));
        }

        if(ecoLevels.containsKey(itemsToCalculateFull.getEcoZone())){
            result = result + (ecoLevels.get(itemsToCalculateFull.getEcoZone()) * doOkl);
        }

        if(qualificationTypes.containsKey(itemsToCalculateFull.getQualityCategory())){

            result = result + (qualificationTypes.get(itemsToCalculateFull.getQualityCategory()) * doOkl);
        }

        if(nisLevels.containsKey(itemsToCalculateFull.getNisProgram())){
            result = result + (nisLevels.get(itemsToCalculateFull.getNisProgram()) * doOkl);
        }

        if(engDiveLevel.containsKey(itemsToCalculateFull.getInEnglish())){
            result = result + engDiveLevel.get(itemsToCalculateFull.getInEnglish()) ;
        }

        if(itemsToCalculateFull.getUpdateHour() != null){
            result = result + ((doOkl / 16) * itemsToCalculateFull.getUpdateHour() * 0.3);
        }

        if(itemsToCalculateFull.getHomeHour() != null){
            result = result + ((doOkl / 16) * itemsToCalculateFull.getHomeHour());
        }

        if(itemsToCalculateFull.getGymHour() != null){
            result = result + ((doOkl / 16) * itemsToCalculateFull.getGymHour() * 0.2);
        }

        if(itemsToCalculateFull.getProfHour() != null){
            result = result + (itemsToCalculateFull.getProfHour() * 95.34);
        }

        if(noteTypes.containsKey(itemsToCalculateFull.getNoteType()) && itemsToCalculateFull.getNoteHour() != null){
            if(noteTypes.get(itemsToCalculateFull.getNoteType()) != 0.4 * bdo){
                result = result + (noteTypes.get(itemsToCalculateFull.getNoteType()) * itemsToCalculateFull.getNoteHour());
            }
            else {
                result = result + noteTypes.get(itemsToCalculateFull.getNoteType());
            }
        }


        return (Math.round(result * 100.0) / 100.0) == 0 ? 0 : (Math.round(result * 100.0) / 100.0);
    }

}
