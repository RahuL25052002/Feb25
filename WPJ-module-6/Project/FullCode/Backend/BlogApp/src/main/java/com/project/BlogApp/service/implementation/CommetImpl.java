package com.project.BlogApp.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.BlogApp.entity.Comment;
import com.project.BlogApp.entity.Post;
import com.project.BlogApp.entity.User;
import com.project.BlogApp.exception.ResourceNotFoundException;
import com.project.BlogApp.paylod.CommentDto;
import com.project.BlogApp.repository.CommentRepo;
import com.project.BlogApp.repository.PostRepo;
import com.project.BlogApp.repository.UserRepo;
import com.project.BlogApp.service.CommentService;


@Service
public class CommetImpl implements CommentService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PostRepo postRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    CommentRepo commentRepo;
    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId, Integer userId) {
        Comment comment = modelMapper.map(commentDto, Comment.class);
        Post post = postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", postId));
        User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", userId));
        comment.setPost(post);
        comment.setUser(user);
        Comment savedComment =  commentRepo.save(comment);
        return modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment", commentId));
        commentRepo.delete(comment);
        
    }
    @Override
    public List<CommentDto> getCommentsByPostId(Integer postId) {
        List<Comment> comments = commentRepo.findByPostPostId(postId);
        return comments.stream().map(comment -> {
            CommentDto dto = modelMapper.map(comment, CommentDto.class);
            dto.setUserName(comment.getUser().getName());
            dto.setId(comment.getUser().getId()); // ✅ Add this line
            return dto;
        }).collect(Collectors.toList());
    }

    
}
