package Model;

import jakarta.persistence.*;

import java.util.List;

public class Category {


    @Entity
    @Table(name = "categories")
    public class Category {
        private int id;
        private List<Post> posts;
        private String name;
        private String description;
        private String image;
        private String slug;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @OneToMany
        public List<Post> getPosts() {
            return posts;
        }

        public void setPosts(List<Post> posts) {
            this.posts = posts;
        }

        @NotBlank(message = "category.name.null")
        @Size(min = 2, max = 50, message = "category.name.size")
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Size(max = 200, message = "category.description.size")
        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        @NotBlank(message = "category.slug.null")
        @Size(min = 2, max = 60, message = "category.slug.size")
        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }
}
