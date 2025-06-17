package com.liame.darkforest.controllers;

import com.liame.darkforest.model.Empire;
import com.liame.darkforest.service.EmpireService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empires")
public class EmpireController {

    private EmpireService empireService;

    public EmpireController(EmpireService empireService) {
        this.empireService = empireService;
    }

    @PostMapping("/create")
    public Empire createEmpire(@RequestBody Empire empire) {
        this.empireService.create(empire);
        return empire;
    }

}
