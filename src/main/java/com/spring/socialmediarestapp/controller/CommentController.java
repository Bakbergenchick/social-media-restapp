package com.spring.socialmediarestapp.controller;

import com.spring.socialmediarestapp.service.CommentService;
import com.spring.socialmediarestapp.utils.request.CommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping()
    public ResponseEntity<?> getAllComments(){
        return new ResponseEntity<>(commentService.getAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createComment(@RequestBody CommentDTO commentDTO){
        return new ResponseEntity<>(commentService.save(commentDTO), HttpStatus.CREATED);
    }
}
