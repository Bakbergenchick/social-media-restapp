package com.spring.socialmediarestapp.controller;

import com.spring.socialmediarestapp.repo.CommentRepo;
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

    private final CommentRepo commentRepo;
    @GetMapping()
    public ResponseEntity<?> getAllComments(){
        return new ResponseEntity<>(commentService.getAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createComment(@RequestBody CommentDTO commentDTO){
        return new ResponseEntity<>(commentService.save(commentDTO), HttpStatus.CREATED);
    }

    //---------Jpa queries-------------------

    @GetMapping("/namedQuery")
    public ResponseEntity<?> getAllCommentsByNamedQuery(){
        return new ResponseEntity<>(commentRepo.findAllComments(), HttpStatus.OK);
    }

//    @GetMapping("/namedQuery")
//    public ResponseEntity<?> findByCommentId(@RequestParam(required = false) Long id){
//        return new ResponseEntity<>(commentRepo.findByCommentId(id), HttpStatus.OK);
//    }
//
//    @GetMapping("/namedQuery")
//    public ResponseEntity<?> findByNameWithLike(@RequestParam(required = false) String name){
//        return new ResponseEntity<>(commentRepo.findByNameWithLike(name), HttpStatus.OK);
//    }

    @GetMapping("/jpaQuery")
    public ResponseEntity<?> findByNameWithLikeJPA(@RequestParam(required = false) String name){
        return new ResponseEntity<>(commentRepo.findByNameWithLikeJPA(name), HttpStatus.OK);
    }

    @GetMapping("/nativeQuery")
    public ResponseEntity<?> findAllWithNativeQuery(){
        return new ResponseEntity<>(commentRepo.findAllWithNativeQuery(), HttpStatus.OK);
    }

    @GetMapping("/nativeQuery/{id}")
    public ResponseEntity<?> findCommentByIdWithNativeQuery(@PathVariable Long id){
        return new ResponseEntity<>(commentRepo.findCommentByIdWithNativeQuery(id), HttpStatus.OK);
    }

    @GetMapping("/nativeQueryWithProjection")
    public ResponseEntity<?> findAllWithProjection(){
        return new ResponseEntity<>(commentRepo.findAllWithProjection(), HttpStatus.OK);
    }


}
