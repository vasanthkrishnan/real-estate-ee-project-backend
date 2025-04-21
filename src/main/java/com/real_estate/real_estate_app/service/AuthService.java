package com.real_estate.real_estate_app.service;

import com.real_estate.real_estate_app.model.User;
import com.real_estate.real_estate_app.repo.DbRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthService {

    @Autowired
    private DbRepo dbRepo;

//    @Autowired
//    private JwtUtil jwtUtil;

    public ResponseEntity<String> addUser(User user) {
        if(dbRepo.existsByusername(user.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Username already present");
        }
        user.setTime(LocalDateTime.now());
        dbRepo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User added successfully");
    }

    public ResponseEntity<String> validateUser(User user) {
        User tempUser = dbRepo.findByemail(user.getEmail());

        if(tempUser == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User not found!");
        } else if(!user.getPassword().equals(tempUser.getPassword())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Invalid Credentials!");
        } else {
//            String token = jwtUtil.generateToken(tempUser.getEmail());
            return ResponseEntity.status(HttpStatus.OK).body("Authenticated");
        }
    }

    public ResponseEntity<String> authorizeViaGoogle(User user) {
        User tempUser = dbRepo.findByemail(user.getEmail());

        if(tempUser == null) {
            user.setTime(LocalDateTime.now());
//            user.setPhotoUrl(user.getPhotoUrl());
            dbRepo.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User added successfully");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("Authenticated");
        }
    }
}
