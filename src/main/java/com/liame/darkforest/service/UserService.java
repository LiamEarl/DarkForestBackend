package com.liame.darkforest.service;

import com.liame.darkforest.model.User;
import com.liame.darkforest.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    //private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User register(User user) {
        //user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }
}
