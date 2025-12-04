package com.example.blogapp.service;


import com.example.blogapp.Model.Comment;
import com.example.blogapp.Repository.CommentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceIMPL implements CommentService {
    private final CommentRepository commentRepository;

    public CommentServiceIMPL(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> findByPostId(int postId) {
        return commentRepository.findByPostId(postId);
    }

    @Override
    public Optional<Comment> findById(int id) {
        return commentRepository.findById(id);
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteById(int id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Page<Comment> findAll(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    @Override
    public Comment approveComment(int id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found with id " + id));
        comment.setApproved(1);
        return commentRepository.save(comment);
    }
}



