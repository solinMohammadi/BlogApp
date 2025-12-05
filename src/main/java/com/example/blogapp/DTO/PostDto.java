package com.example.blogapp.DTO;


import com.example.blogapp.Model.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public record PostDto(
        Integer id,

        @NotBlank(message = "Slug is required")
        String slug,

        @NotBlank(message = "Title is required")
        String title,

        @NotBlank(message = "Content is required")
        String content,

        String excerpt,

        String imageUrl,

        @NotNull(message = "Status is required")
        Status status,

        LocalDateTime publishedAt,

        Integer views,

        Integer categoryId,
        String categoryName,

        List<Integer> tagIds,
        List<String> tagNames
) {}