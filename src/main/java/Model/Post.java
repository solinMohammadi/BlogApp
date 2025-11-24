package Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jdk.jfr.Category;
import org.hibernate.annotations.CreationTimestamp;

import javax.xml.stream.events.Comment;
import java.time.LocalDateTime;
import java.util.List;

@Entity
    @Table(name = "posts")
    public class Post {
        private int id;
        private String title;
        private String content;
        private Category category;
        private List<Comment> comments;
        private List<Tag> tags;
        private User author;
        private LocalDateTime createdAt;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Size(min = 3, max = 100, message = "title.size")
        @NotBlank(message = "title.null")
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Size(min = 10, max = 5000, message = "content.size")
        @NotBlank(message = "content.null")
        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @ManyToOne
        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }

        @OneToMany
        public List<Comment> getComments() {
            return comments;
        }

        public void setComments(List<Comment> comments) {
            this.comments = comments;
        }

        @OneToMany
        public List<Tag> getTags() {
            return tags;
        }

        public void setTags(List<Tag> tags) {
            this.tags = tags;
        }

        @ManyToOne
        public User getAuthor() {
            return author;
        }

        public void setAuthor(User author) {
            this.author = author;
        }

        @CreationTimestamp
        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }

}
