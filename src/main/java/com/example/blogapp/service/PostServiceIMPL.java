package com.example.blogapp.service;


import com.example.blogapp.Model.Post;
import com.example.blogapp.Model.Tag;
import com.example.blogapp.Model.User;
import com.example.blogapp.Repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.data.domain.Pageable;

import java.util.List;


@Service
public class PostServiceIMPL implements PostService {
    private final PostRepository postRepository;

    public PostServiceIMPL(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public List<Post> findAll(User user) {
        return postRepository.findAllByAuthor(user);
    }

    @Override
    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }

    @Override
    public Optional<Post> findBySlug(String slug) {
        return postRepository.findBySlug(slug);
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deleteById(int id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<Post> findByTag(Tag tag){
        return postRepository.findAllByTagsContaining(tag);
    }

    @Override
    public long count() {
        return postRepository.count();
    }
}