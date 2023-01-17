package com.spring.socialmediarestapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@NamedQueries({
        @NamedQuery(name = "Comment.findAllComments", query = "select c from Comment c"),
        @NamedQuery(name = "Comment.findByCommentId", query = "select c from Comment c where c.id = ?1"),
        @NamedQuery(name = "Comment.findByNameWithLike", query = "select c from Comment c where c.name like ?1")
})

@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "findAllWithNativeQuery",
                entities = {
                        @EntityResult(entityClass = Comment.class)
                }
        ),
        @SqlResultSetMapping(
                name = "findCommentByIdWithNativeQuery",
                entities = {
                        @EntityResult(entityClass = Comment.class)
                }
        )
})

@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Comment.findAllWithNativeQuery",
                query = "select c.* from comment c",
                resultSetMapping = "findAllWithNativeQuery"
        ),
        @NamedNativeQuery(
                name = "Comment.findCommentByIdWithNativeQuery",
                query = "select c.* from comment c where c.id = ?1",
                resultSetMapping = "findCommentByIdWithNativeQuery"
        )
})
@Entity
@Getter
@Setter
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name ="post_id")
    private Post post;
}
