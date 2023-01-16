package com.spring.socialmediarestapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "title"))
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Integer commentsAmount;
    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Comment> comments;

}
