package com.example.blogapp.Repository;


import com.example.blogapp.Model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
        Page<Post> findByAuthorId(Integer authorId , Pageable pageable);

        Page<Post> findByTitleContainingIgnoreCase(String title , Pageable pageable);

        Page<Post> findByContentContainingIgnoreCase(String content , Pageable pageable);

        Page<Post> findByCategoryId(Integer categoryId, Pageable pageable);



}
