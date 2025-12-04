package com.example.blogapp.controller;

import com.example.blogapp.Model.Post;
import ch.qos.logback.core.model.Model;
import com.example.blogapp.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.security.access.prepost.PreAuthorize;
@Controller
    public class PageController {

        private final PostService postService;

        public PageController(PostService postService) {
            this.postService = postService;
        }

        @GetMapping("/")
        public String index(Model model, Pageable pageable) {
            Page<Post> posts = postService.findAll(pageable);
            model.addAttribute("posts", posts);
            return "index";
        }

        @GetMapping("/auth/login")
        public String login() {
            return "login";
        }

        @GetMapping("/auth/register")
        public String register() {
            return "register";
        }

        @GetMapping("/admin/posts")
        public String adminPosts(Model model, Pageable pageable) {
            Page<Post> page = postService.findAll(pageable);
            model.addAttribute("posts", page != null ? page : Page.empty());
            return "admin/posts";
        }

        @GetMapping("/admin/categories-tags")
        @PreAuthorize("hasRole('ADMIN')")
        public String adminCategoriesTags() {
            return "admin/categories-tags";
        }

        @GetMapping("/admin/comments")
        @PreAuthorize("hasRole('ADMIN')")
        public String adminComments() {
            return "admin/comments";
        }

        @GetMapping("/admin/users")
        @PreAuthorize("hasRole('ADMIN')")
        public String adminUsers() {
            return "admin/users";
        }

        @GetMapping("/posts/view/{slug}")
        public String showPost(@PathVariable String slug, Model model) {
            Post post = postService.findBySlug(slug)
                    .orElseThrow(() -> new IllegalArgumentException("Post not found"));
            model.addAttribute("post", post);
            model.addAttribute("comments", post.getComments());
            return "post";
        }

    }







