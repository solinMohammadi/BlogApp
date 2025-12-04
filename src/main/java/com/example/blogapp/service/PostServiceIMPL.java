package com.example.blogapp.service;


import com.example.blogapp.Model.Post;
import com.example.blogapp.Repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
@Service
    public class PostServiceIMPL implements PostService {

        private final PostRepository postRepository;
        public PostServiceIMPL(PostRepository postRepository) {
            this.postRepository = postRepository;
        }

        @Override
        public Post save(Post post) {
            return postRepository.save(post);
        }

        @Override
        public Optional<Post> findById(Integer id) {
            return postRepository.findById(id);
        }



    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }


    @Override
        public void deleteById(Integer id) {
            postRepository.deleteById(id);
        }

        @Override
        public Post update(Integer id, Post post) {
            return postRepository.findById(id)
                    .map(existingPost -> {
                        existingPost.setTitle(post.getTitle());
                        existingPost.setContent(post.getContent());
                        existingPost.setCategory(post.getCategory());
                        existingPost.setAuthor(post.getAuthor());
                        return postRepository.save(existingPost);
                    })
                    .orElseThrow(() -> new RuntimeException("Post not found with id: " + id));
        }


    @Override
        public Page<Post> findByTitleAndContentContaining(String keyword, Pageable pageable) {
            Page<Post> byTitle = postRepository.findByTitleContainingIgnoreCase(keyword, pageable);
            if (byTitle.hasContent()) {
                return byTitle;
            }
            return postRepository.findByContentContainingIgnoreCase(keyword, pageable);
        }

        @Override
        public Page<Post> findByCategoryId(Integer categoryId, Pageable pageable) {
            return postRepository.findByCategoryId(categoryId, pageable);
        }

}
