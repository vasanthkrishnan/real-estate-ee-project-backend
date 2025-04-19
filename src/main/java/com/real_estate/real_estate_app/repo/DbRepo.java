package com.real_estate.real_estate_app.repo;

import com.real_estate.real_estate_app.model.UserSignUp;
import com.real_estate.real_estate_app.model.UserSingIn;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbRepo extends MongoRepository<UserSignUp, ObjectId> {
    boolean existsByusername(String username);

    UserSingIn findByemail(String email);
}
