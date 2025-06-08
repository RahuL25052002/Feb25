package com.project.BlogApp.service;

import java.util.List;

import com.project.BlogApp.paylod.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto, Integer UserId, Integer useId);
   // CommentDto getComment();
    void deleteComment(Integer commentId);
//    CommentDto createComment(CommentDto commentDto, Integer postId, Integer userId);
//    void deleteComment(Integer commentId);
    List<CommentDto> getCommentsByPostId(Integer postId); // New

    
}
