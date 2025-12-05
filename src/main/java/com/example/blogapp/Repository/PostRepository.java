package com.example.blogapp.Repository;

import com.example.blogapp.Model.Post;
import com.example.blogapp.Model.Tag;
import com.example.blogapp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Integer> {
        Optional<Post> findBySlug(String slug);
        List<Post> findAllByAuthor(User author);
        List<Post> findAllByTagsContaining(Tag tag);
}