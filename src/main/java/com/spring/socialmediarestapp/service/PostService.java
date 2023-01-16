package com.spring.socialmediarestapp.service;

import com.spring.socialmediarestapp.utils.request.CommentDTO;
import com.spring.socialmediarestapp.utils.request.PostDTO;
import com.spring.socialmediarestapp.utils.response.CommentResponseDTO;
import com.spring.socialmediarestapp.utils.response.PostResponseDTO;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<PostResponseDTO> getAllPosts();

    Optional<PostResponseDTO> getPost(Long id);

    PostResponseDTO savePost(PostDTO postDTO);

    String deletePost(Long id);
}
