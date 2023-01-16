package com.spring.socialmediarestapp.utils.response;

import com.spring.socialmediarestapp.entity.Comment;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
public class PostResponseDTO {
    private Long id;
    private String title;
    private String description;
    private Integer commentsAmount;
    private String content;
    private Set<CommentResponseDTO> comments;
}
