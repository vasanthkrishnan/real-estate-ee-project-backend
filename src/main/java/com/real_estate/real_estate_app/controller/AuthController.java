package com.real_estate.real_estate_app.controller;

import com.real_estate.real_estate_app.controller.service.AuthService;
import com.real_estate.real_estate_app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/sign-up")
    public String Authorize(@RequestBody User user) {
        return authService.addUser(user);
    }

}
