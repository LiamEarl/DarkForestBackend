package com.liame.darkforest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.liame.darkforest.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
