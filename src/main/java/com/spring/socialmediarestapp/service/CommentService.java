package com.spring.socialmediarestapp.service;

import com.spring.socialmediarestapp.entity.Comment;
import com.spring.socialmediarestapp.utils.request.CommentDTO;
import com.spring.socialmediarestapp.utils.response.CommentResponseDTO;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<CommentResponseDTO> getAll();

    Optional<CommentResponseDTO> getComment(Long id);

    CommentResponseDTO save(CommentDTO commentDTO);

    String delete(Long id);

}
