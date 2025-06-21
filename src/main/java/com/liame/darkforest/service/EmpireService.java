package com.liame.darkforest.service;

import com.liame.darkforest.dto.EmpireDTO;
import com.liame.darkforest.model.Empire;
import com.liame.darkforest.model.User;
import com.liame.darkforest.repo.EmpireRepository;
import com.liame.darkforest.repo.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpireService {
    private EmpireRepository empireRepository;

    public EmpireService(EmpireRepository empireRepository) {

        this.empireRepository = empireRepository;
    }


    public Empire create(EmpireDTO empireDto, User owner) {
        Empire createdEmpire = new Empire();
        createdEmpire.setName(empireDto.getName());
        createdEmpire.setType(empireDto.getType());
        createdEmpire.setOwner(owner);
        this.empireRepository.save(createdEmpire);
        return createdEmpire;
    }
}
