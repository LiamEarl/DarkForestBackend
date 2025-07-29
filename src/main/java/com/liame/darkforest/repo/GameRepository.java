package com.liame.darkforest.repo;

import com.liame.darkforest.model.database.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Game findByCode(String code);
}
