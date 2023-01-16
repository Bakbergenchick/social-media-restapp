package com.spring.socialmediarestapp.controller;

import com.spring.socialmediarestapp.service.PostService;
import com.spring.socialmediarestapp.utils.request.PostDTO;
import com.spring.socialmediarestapp.utils.response.PostResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping()
    public ResponseEntity<?> getAllPostS(){
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPost(@PathVariable Long id){
        return new ResponseEntity<>(postService.getPost(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createPost(@Valid @RequestBody PostDTO postDTO){
        return new ResponseEntity<>(postService.savePost(postDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id){
        return new ResponseEntity<>(postService.deletePost(id), HttpStatus.OK);
    }

}
