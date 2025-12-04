package com.example.blogapp.service;

import com.example.blogapp.Model.Category;
import com.example.blogapp.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceIMPL implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceIMPL(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }
}