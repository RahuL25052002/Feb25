package com.project.BlogApp.service;

import java.util.List;
import com.project.BlogApp.paylod.PostDto;
import com.project.BlogApp.paylod.PostResponse;

public interface PostService {
    PostDto createPost(Integer userId, Integer categoryId, PostDto PostDto);

    PostDto updatePost(PostDto postDto, Integer postId);

    PostDto getPostById(Integer postId);
    List<PostDto> getAllPost();
    PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy);
    List<PostDto> getPostByCategory(Integer category_id);
    List<PostDto> getPostByUser(Integer user_id);
    List<PostDto> getPost();
    List<PostDto> searchPost(String keyword);
    void deletePost(Integer postId);

    

}
