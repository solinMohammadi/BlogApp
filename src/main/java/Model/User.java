package Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;

import javax.management.relation.Role;
import java.time.LocalDateTime;



    @Entity
    @Table(name = "users_blog")
    public class User {
        private int id;
        private String username;
        private String password;
        private String email;
        private String fullName;
        private Role role;
        private LocalDateTime createdAt;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @NotBlank(message = "username.null")
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        @NotBlank(message = "password.null")
        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Email(message = "email.invalid")
        @NotBlank(message = "email.null")
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @NotBlank(message = "fullname.null")
        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        public Role getRole() {
            return role;
        }

        public void setRole(Role role) {
            this.role = role;
        }

        @CreationTimestamp
        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }
}
