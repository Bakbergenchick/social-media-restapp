package com.spring.socialmediarestapp.controller;

import com.spring.socialmediarestapp.repo.PostRepo;
import com.spring.socialmediarestapp.service.PostService;
import com.spring.socialmediarestapp.utils.ValidateObjects;
import com.spring.socialmediarestapp.utils.ValidateUtils;
import com.spring.socialmediarestapp.utils.request.PostDTO;
import com.spring.socialmediarestapp.utils.response.PostResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    private final PostRepo postRepo;

    @GetMapping()
    public ResponseEntity<?> getAllPostS(){
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPost(@PathVariable Long id){
        return new ResponseEntity<>(postService.getPost(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createPost(@RequestBody PostDTO postDTO){
        Map<String, String> errors = ValidateObjects.validatePostDTO(postDTO);

        if (!ObjectUtils.isEmpty(errors)){
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(postService.savePost(postDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id){

        return new ResponseEntity<>(postService.deletePost(id), HttpStatus.OK);
    }

    @GetMapping("/getAllWithPagination")
    public ResponseEntity<?> getAllWithPagination(@PageableDefault Pageable pageable){

        return new ResponseEntity<>(postRepo.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/getAllWithCustomPagination")
    public ResponseEntity<?> getAllWithCustomPagination(
            @RequestParam(defaultValue = "3", required = false) int size,
            @RequestParam(defaultValue = "1", required = false) int page,
            @RequestParam(defaultValue = "asc", required = false) String direction,
            @RequestParam(defaultValue = "", required = false) String properties,
            @RequestParam(defaultValue = "", required = false) String content,
            @RequestParam(defaultValue = "", required = false) String title
    ){
        return new ResponseEntity<>(
                postRepo.findAllWithCustomProperties(size, page, direction, properties, content, title),
                HttpStatus.OK);
    }


}
