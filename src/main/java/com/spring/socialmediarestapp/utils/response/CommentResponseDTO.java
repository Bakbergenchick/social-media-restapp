package com.spring.socialmediarestapp.utils.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.socialmediarestapp.entity.Post;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class CommentResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String body;
    @JsonIgnore
    private Post post;
}
