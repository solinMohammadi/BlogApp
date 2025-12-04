package com.example.blogapp.service;


import com.example.blogapp.Model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Optional<Category> findById(int id);
    List<Category> findAll();
    Category save(Category category);
    void deleteById(int id);
}