package com.additional_project.salary_calculator.repository;

import com.additional_project.salary_calculator.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends MongoRepository<User, Long > {
    User findByLogin(String login);
}
