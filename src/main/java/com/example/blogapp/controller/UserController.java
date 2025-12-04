package com.example.blogapp.controller;

import com.example.blogapp.Model.Role;
import com.example.blogapp.Model.User;
import com.example.blogapp.DTO.RegisterDto;
import com.example.blogapp.DTO.UserDto;
import com.example.blogapp.service.PostServiceIMPL;
import com.example.blogapp.service.UserServiceIMPL;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/users")
@Controller
public class UserController {

    private final UserServiceIMPL userServiceImpl;
    private final PasswordEncoder passwordEncoder;
    private final PostServiceIMPL postServiceImpl;


    public UserController(UserServiceIMPL userServiceImpl, PasswordEncoder passwordEncoder, PostServiceIMPL postServiceImpl) {
        this.userServiceImpl = userServiceImpl;
        this.passwordEncoder = passwordEncoder;
        this.postServiceImpl = postServiceImpl;
    }

    @PostMapping("/register")
    public String register(@Valid RegisterDto registerDto) {
        if(!registerDto.password().equals(registerDto.rePassword())) {
            return "redirect:/register?error=password_mismatch";
        }

        if (userServiceImpl.findByUsername(registerDto.username()).isPresent()) {
            return "redirect:/register?error=username_taken";
        }

        User user = new User();
        user.setUsername(registerDto.username());
        user.setFullName(registerDto.fullName());
        user.setEmail(registerDto.email());
        user.setPassword(passwordEncoder.encode(registerDto.password()));
        user.setRole(Role.USER);

        userServiceImpl.save(user);

        return "redirect:/login?success=true";
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseBody
    public ResponseEntity<Page<UserDto>> getAllUsers(Pageable pageable) {
        Page<User> users = userServiceImpl.findAll(pageable);
        Page<UserDto> result = users.map(u -> new UserDto(u.getId(), u.getUsername(), u.getRole()));
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}/role")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> updateUserRole(@PathVariable int id, @RequestParam Role role) {
        User user = userServiceImpl.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id " + id));

        user.setRole(role);
        User updated = userServiceImpl.save(user);

        return ResponseEntity.ok(updated);
    }

}