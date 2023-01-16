package com.spring.socialmediarestapp.service.impls;

import com.spring.socialmediarestapp.entity.Post;
import com.spring.socialmediarestapp.errors.ResourceNotFoundException;
import com.spring.socialmediarestapp.repo.CommentRepo;
import com.spring.socialmediarestapp.repo.PostRepo;
import com.spring.socialmediarestapp.service.PostService;
import com.spring.socialmediarestapp.utils.request.PostDTO;
import com.spring.socialmediarestapp.utils.response.PostResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.spring.socialmediarestapp.service.impls.CommentServiceImpl.mapperToCommentDTO;

@Service
@Transactional
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;


    @Override
    public List<PostResponseDTO> getAllPosts() {
        return postRepo.findAll()
                .stream()
                .map(this::mapperToPostDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PostResponseDTO> getPost(Long id) {
        Post post = postRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id = " + id + " not found!"));

        return Optional.of(mapperToPostDTO(post));
    }

    @Override
    public PostResponseDTO savePost(PostDTO postDTO) {
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setDescription(postDTO.getDescription());
        post.setCommentsAmount(postDTO.getCommentsAmount());

        Post savedPost = postRepo.save(post);
        return mapperToPostDTO(savedPost);
    }

    @Override
    public String deletePost(Long id) {
        return null;
    }

    private PostResponseDTO mapperToPostDTO(Post post){
        PostResponseDTO postResponseDTO = new PostResponseDTO();
        postResponseDTO.setId(post.getId());
        postResponseDTO.setTitle(post.getTitle());
        postResponseDTO.setContent(post.getContent());
        postResponseDTO.setDescription(post.getDescription());
        postResponseDTO.setCommentsAmount(post.getCommentsAmount());

        if (post.getComments() != null && post.getComments().size() > 0) {
            postResponseDTO.setComments(post.getComments()
                    .stream()
                    .map(CommentServiceImpl::mapperToCommentDTO)
                    .collect(Collectors.toSet()));
        }

        return postResponseDTO;
    }
}
