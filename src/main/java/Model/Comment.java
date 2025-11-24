package Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Table(name = "comments")
    public class Comment {
        private int id;
        private Post post;
        private User user;
        private CommentsStatus status;
        private String content;
        private LocalDateTime time;

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

        @ManyToOne
        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        @Enumerated(EnumType.STRING)
        public CommentsStatus getStatus() {
            return status;
        }

        public void setStatus(CommentsStatus status) {
            this.status = status;
        }

        @NotBlank(message = "comment.content.null")
        @Size(min = 1, max = 500, message = "comment.content.size")
        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @CreationTimestamp
        public LocalDateTime getTime() {
            return time;
        }

        public void setTime(LocalDateTime time) {
            this.time = time;
        }

}
