package com.additional_project.salary_calculator.repository;

import com.additional_project.salary_calculator.entity.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, Long > {

}
