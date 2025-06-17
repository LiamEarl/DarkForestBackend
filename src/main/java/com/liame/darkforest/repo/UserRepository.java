package com.liame.darkforest.repo;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import com.liame.darkforest.model.User;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
