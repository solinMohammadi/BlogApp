package com.example.blogapp.Repository;

import com.example.blogapp.Model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
    Tag findBySlug(String slug);
}