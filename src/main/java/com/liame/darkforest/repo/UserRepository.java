package com.liame.darkforest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.liame.darkforest.model.database.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
