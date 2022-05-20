package com.example.codingbatstructure.repository;

import com.example.codingbatstructure.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    boolean existsByUsername(String username);
    User findByUsername(String username);
    boolean existsByUsernameAndIdIsNot(String username,Integer id);
}
