package com.spring.socialmediarestapp.service.impls;

import com.spring.socialmediarestapp.entity.Comment;
import com.spring.socialmediarestapp.entity.Post;
import com.spring.socialmediarestapp.errors.ResourceNotFoundException;
import com.spring.socialmediarestapp.repo.CommentRepo;
import com.spring.socialmediarestapp.repo.PostRepo;
import com.spring.socialmediarestapp.service.CommentService;
import com.spring.socialmediarestapp.utils.request.CommentDTO;
import com.spring.socialmediarestapp.utils.response.CommentResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepo commentRepo;
    private final PostRepo postRepo;

    @Override
    public List<CommentResponseDTO> getAll() {
        return commentRepo.findAll()
                .stream()
                .map(CommentServiceImpl::mapperToCommentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CommentResponseDTO> getComment(Long id) {
        Comment comment = commentRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Comment with id=" + id + " not found"));
        return Optional.of(mapperToCommentDTO(comment));
    }

    @Override
    public CommentResponseDTO save(CommentDTO commentDTO) {
        Post post = postRepo.findById(commentDTO.getPost_id())
                .orElseThrow(() -> new ResourceNotFoundException("Post with id = " + commentDTO.getPost_id() + " not found!"));

        Comment comment = new Comment();
        comment.setName(commentDTO.getName());
        comment.setEmail(commentDTO.getEmail());
        comment.setBody(commentDTO.getBody());
        comment.setPost(post);

        Comment savedComment = commentRepo.save(comment);
        return mapperToCommentDTO(savedComment);
    }

    @Override
    public String delete(Long id) {
        return null;
    }

    public static CommentResponseDTO mapperToCommentDTO(Comment comment){
        CommentResponseDTO commentDTO = new CommentResponseDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setName(comment.getName());
        commentDTO.setBody(comment.getBody());
        commentDTO.setEmail(comment.getEmail());
        commentDTO.setPost(comment.getPost());

        return commentDTO;
    }

}
