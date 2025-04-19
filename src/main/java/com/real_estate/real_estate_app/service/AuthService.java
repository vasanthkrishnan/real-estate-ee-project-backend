package com.real_estate.real_estate_app.service;

import org.springframework.dao.DuplicateKeyException;
import com.real_estate.real_estate_app.model.User;
import com.real_estate.real_estate_app.repo.DbRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthService {

    @Autowired
    private DbRepo dbRepo;

    public String addUser(User user) {
        if(dbRepo.existsByusername(user.getUsername())) {
            return "User name already present";
        }
        user.setTime(LocalDateTime.now());
        dbRepo.save(user);
        return "User added successfully...";
    }
}
