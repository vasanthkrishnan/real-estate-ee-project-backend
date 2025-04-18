package com.real_estate.real_estate_app.controller.service;

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
        user.setTime(LocalDateTime.now());

        try {
            dbRepo.save(user);
            return "User added Successfully...";
        } catch (DuplicateKeyException e) {
            System.out.println("Username already present");
            return "User name already present";
        }
    }
}
