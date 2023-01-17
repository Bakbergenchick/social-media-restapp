package com.spring.socialmediarestapp.repo;

import com.spring.socialmediarestapp.entity.Comment;
import com.spring.socialmediarestapp.utils.response.CommentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {

    List<Comment> findAllComments();

    List<Comment> findAllWithNativeQuery();

    @Query(value = "select c.id as commentId, c.name as commentName, c.email as commentEmail, c.body as commentBody " +
            "from comment c", nativeQuery = true)
    List<CommentProjection> findAllWithProjection();

    Comment findByCommentId(Long id);

    Comment findCommentByIdWithNativeQuery(Long id);

    List<Comment> findByNameWithLike(String name);

    @Query("select c from Comment c where c.name like %?1%")
    List<Comment> findByNameWithLikeJPA(String name);



}
