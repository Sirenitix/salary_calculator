package com.additional_project.salary_calculator.repository;

import com.additional_project.salary_calculator.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository  extends MongoRepository<User, Long > {
    User findByLogin(String login);

}
