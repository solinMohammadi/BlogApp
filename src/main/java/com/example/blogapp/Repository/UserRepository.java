package com.example.blogapp.Repository;

import com.example.blogapp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
        Optional<User> findByUsername(String username);
    }


