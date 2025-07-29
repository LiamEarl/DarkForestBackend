package com.liame.darkforest.controllers;

import com.liame.darkforest.dto.EmpireDTO;
import com.liame.darkforest.model.database.Empire;
import com.liame.darkforest.model.database.User;
import com.liame.darkforest.repo.UserRepository;
import com.liame.darkforest.service.EmpireService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/empires")
public class EmpireController {

    private UserRepository userRepository;
    private EmpireService empireService;

    public EmpireController(EmpireService empireService, UserRepository userRepository) {
        this.empireService = empireService;
        this.userRepository = userRepository;
    }

    @PostMapping("/create")
    public Empire createEmpire(@RequestBody EmpireDTO empire, Authentication authentication) {
        String username = authentication.getName();

        User owner = userRepository.findByUsername(username);
        if(owner == null) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }

        return empireService.create(empire, owner);
    }

}
