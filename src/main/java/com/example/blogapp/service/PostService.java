package com.example.blogapp.service;

import com.example.blogapp.Model.Post;
import com.example.blogapp.Model.Tag;
import com.example.blogapp.Model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

import java.util.List;


    public interface PostService {
        Page<Post> findAll(Pageable pageable);

        List<Post> findAll(User user);

        Optional<Post> findById(int id);

        Optional<Post> findBySlug(String slug);

        Post save(Post post);

        void deleteById(int id);

        List<Post> findByTag(Tag tag);

        long count();
    }