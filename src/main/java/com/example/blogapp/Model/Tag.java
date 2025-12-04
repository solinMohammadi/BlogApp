package com.example.blogapp.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
    @Table(name = "tags")
    public class Tag {
        private int id;
        private Post post;
        private String name;
        private String slug;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @ManyToOne
        public Post getPost() {
            return post;
        }

        public void setPost(Post post) {
            this.post = post;
        }

        @NotBlank(message = "tag.name.null")
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @NotBlank(message = "tag.slug.null")
        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }
}
