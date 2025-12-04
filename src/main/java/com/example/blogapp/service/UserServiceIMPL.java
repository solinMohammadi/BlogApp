package com.example.blogapp.service;


import com.example.blogapp.Model.User;
import com.example.blogapp.Repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceIMPL implements UserDetailsService, UserService {

    private final UserRepository userRepository;

    public UserServiceIMPL(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("Username not found"));
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build();
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Optional<User> findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }


}