package com.real_estate.real_estate_app.repo;

import com.real_estate.real_estate_app.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbRepo extends MongoRepository<User, String> {
}
