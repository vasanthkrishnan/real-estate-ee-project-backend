package com.real_estate.real_estate_app.controller;

import com.real_estate.real_estate_app.model.UserSingIn;
import com.real_estate.real_estate_app.service.AuthService;
import com.real_estate.real_estate_app.model.UserSignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<String> Authorize(@RequestBody UserSignUp user) {
        return authService.addUser(user);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<String> SignIn(@RequestBody UserSingIn user) {
        return authService.validateUser(user);
    }

}
