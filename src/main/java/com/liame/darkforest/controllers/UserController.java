package com.liame.darkforest.controllers;

import com.liame.darkforest.dto.LoginDTO;
import com.liame.darkforest.dto.UserDTO;
import com.liame.darkforest.model.User;
import com.liame.darkforest.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public UserDTO register(@RequestBody User user) {
        User createdUser = service.register(user);

        return new UserDTO(createdUser.getUsername(), createdUser.getId());
    }

    @PostMapping("/login")
    public LoginDTO login(@RequestBody User user) {
        return new LoginDTO(new UserDTO(service.find(user.getUsername())), service.verify(user));
    }

}
