package com.real_estate.real_estate_app.controller;

import com.real_estate.real_estate_app.service.AuthService;
import com.real_estate.real_estate_app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/sign-up")
    public String Authorize(@RequestBody User user) {
        return authService.addUser(user);
    }

}
