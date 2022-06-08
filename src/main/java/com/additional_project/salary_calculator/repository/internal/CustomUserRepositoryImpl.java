package com.additional_project.salary_calculator.repository.internal;

import com.additional_project.salary_calculator.entity.User;
import com.additional_project.salary_calculator.repository.CustomUserRepository;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class CustomUserRepositoryImpl implements CustomUserRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void updateUserSalary(String login, double salary) {
            Query query = new Query(Criteria.where("login").is(login));
            Update update = new Update();
            update.set("salary", salary);

            UpdateResult result = mongoTemplate.updateFirst(query, update, User.class);

            if(result == null)
                System.out.println("No documents updated");
            else
                System.out.println(result.getModifiedCount() + " document(s) updated..");


    }
}
