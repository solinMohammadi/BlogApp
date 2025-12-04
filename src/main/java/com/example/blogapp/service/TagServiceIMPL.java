package com.example.blogapp.service;


import com.example.blogapp.Model.Tag;
import com.example.blogapp.Repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

     @Service
     public class TagServiceIMPL implements TagService {
    private final TagRepository tagRepository;

    public TagServiceIMPL(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public List<Tag> findAllById(List<Integer> ids) {
        return tagRepository.findAllById(ids);
    }

    @Override
    public Optional<Tag> findById(int id) {
        return tagRepository.findById(id);
    }

    @Override
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public void deleteById(int id) {
        tagRepository.deleteById(id);
    }

    @Override
    public Tag findBySlug(String slug) {
        return tagRepository.findBySlug(slug);
    }
}