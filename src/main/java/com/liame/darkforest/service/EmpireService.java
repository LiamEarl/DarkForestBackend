package com.liame.darkforest.service;

import com.liame.darkforest.model.Empire;
import com.liame.darkforest.repo.EmpireRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpireService {
    private EmpireRepository empireRepository;
    public EmpireService(EmpireRepository empireRepository) {
        this.empireRepository = empireRepository;
    }

    @Transactional
    public Empire create(Empire empire) {
        this.empireRepository.save(empire);
        return empire;
    }
}
