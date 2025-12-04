package com.example.blogapp.DTO;


import com.example.blogapp.Model.Role;

public record UserDto(int id, String username, Role role) {

}