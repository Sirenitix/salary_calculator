package com.additional_project.salary_calculator.service.internal;

import com.additional_project.salary_calculator.entity.Profile;
import com.additional_project.salary_calculator.repository.ProfileRepository;
import com.additional_project.salary_calculator.service.SalaryService;
import org.springframework.stereotype.Service;

@Service
public class SalaryServiceImpl implements SalaryService {

    ProfileRepository profileRepository;

    public SalaryServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public int calculate() {
        return 0;
    }

    @Override
    public void createProfile(Profile profile) {
        profileRepository.save(profile);
    }
}
