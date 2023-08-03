package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.dto.RegisterDTO;
import com.db.grad.javaapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class UsersController {
    @Autowired
    UserService userService;

    @PutMapping("/register")
    void registerUser(@RequestBody RegisterDTO registerDTO) {
        this.userService.saveUser(registerDTO);
    }
}
