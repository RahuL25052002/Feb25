package com.project.BlogApp.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.BlogApp.entity.Comment;
import com.project.BlogApp.paylod.APIResponse;
import com.project.BlogApp.paylod.CommentDto;
import com.project.BlogApp.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController{

    @Autowired
    CommentService commentService;

    @Autowired
    ModelMapper modelMapper;
    
    @GetMapping("/post/{postId}/comments")
    public ResponseEntity<List<CommentDto>> getCommentsByPostId(@PathVariable Integer postId) {
        List<CommentDto> comments = commentService.getCommentsByPostId(postId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }


    @PostMapping("{postId}/by/{userId}")
    public ResponseEntity<Comment> createComment(
        @RequestBody CommentDto commentDto,
        @PathVariable("postId") Integer postId,
        @PathVariable("userId") Integer userId
    ){
        CommentDto commentDto2 = commentService.createComment(commentDto, postId, userId);
        return new ResponseEntity<>(modelMapper.map(commentDto2, Comment.class), HttpStatus.CREATED);
    }

    @DeleteMapping("{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable("commentId") Integer commentId){
        commentService.deleteComment(commentId);
        return new ResponseEntity<>(new APIResponse("Comment Deleted Successfully", true),HttpStatus.OK);
    }
}

