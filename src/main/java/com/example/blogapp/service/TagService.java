package com.example.blogapp.service;

import com.example.blogapp.Model.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {

    List<Tag> findAll();
    List<Tag> findAllById(List<Integer> ids);
    Optional<Tag> findById(int id);
    Tag save(Tag tag);
    void deleteById(int id);
    Tag findBySlug(String slug);


}
