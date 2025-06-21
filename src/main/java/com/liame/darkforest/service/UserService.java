package com.liame.darkforest.service;

import com.liame.darkforest.model.User;
import com.liame.darkforest.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private UserRepository repo;
    private AuthenticationManager authManager;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(11);
    private JWTService jwtService;

    public UserService(UserRepository repo, AuthenticationManager authManager, JWTService jwtService) {
        this.repo = repo;
        this.authManager = authManager;
        this.jwtService = jwtService;
    }

    //private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public User register(User user) {
        if(repo.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username is already in use");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        return this.repo.save(user);
    }

    public User find(String username) {
        return this.repo.findByUsername(username);
    }

    public String verify(User user) {
        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if(authentication.isAuthenticated()) return jwtService.generateToken(user.getUsername());
        return "FAILED";
    }
}
