package com.liame.darkforest.repo;

import com.liame.darkforest.model.database.Empire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpireRepository extends JpaRepository<Empire, Long> {}
