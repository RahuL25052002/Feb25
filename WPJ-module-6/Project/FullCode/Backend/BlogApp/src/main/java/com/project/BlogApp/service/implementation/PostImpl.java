package com.project.BlogApp.service.implementation;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.project.BlogApp.entity.Categories;
import com.project.BlogApp.entity.Post;
import com.project.BlogApp.entity.User;
import com.project.BlogApp.exception.ResourceNotFoundException;
import com.project.BlogApp.paylod.PostDto;
import com.project.BlogApp.paylod.PostResponse;
import com.project.BlogApp.repository.CategoryRepo;
import com.project.BlogApp.repository.PostRepo;
import com.project.BlogApp.repository.UserRepo;
import com.project.BlogApp.service.PostService;

@Service
public class PostImpl implements PostService{
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PostRepo postRepo;
    
    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    UserRepo userRepo;

    // create
    @Override
    public PostDto createPost(Integer userId, Integer categoryId, PostDto PostDto) {

        Post post = modelMapper.map(PostDto, Post.class);
        
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User",userId));
        //post.setUser(modelMapper.map(userRepo.save(user),UserDto.class));
        Categories categories = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category",categoryId));
        //post.setCategories(modelMapper.map(categoryRepo.save(categories),Category.class));
        
        post.setUser(user);
        post.setCategories(categories);
        //post.setDate(Date.valueOf("2024-02-06"));
        Date date = new Date(System.currentTimeMillis());
        post.setDate(date);
        
        return modelMapper.map(postRepo.save(post),PostDto.class);
        
    
    
    }

    //update
    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post",postId));
        post.setPostId(postDto.getPostId());
        post.setDate(postDto.getDate());
        post.setName(postDto.getName());
        post.setContent(postDto.getContent());
        post.setCategories(post.getCategories());
        post.setUser(post.getUser());
        post.setFile(postDto.getFile());
        postRepo.save(post);
        return modelMapper.map(post , PostDto.class);
    }

    // get

    //v-1
     @Override
     public List<PostDto> getAllPost(){
         List<Post> posts = postRepo.findAll();
         return posts.stream().map((e)->modelMapper.map(e, PostDto.class)).collect(Collectors.toList());
     }

    // //v-2
    // @Override
    // public List<PostDto> getAllPost(int pageNumber,int pageSize){
    //     Pageable p = PageRequest.of(pageNumber, pageSize);
    //     Page <Post> page = postRepo.findAll(p);
    //     List<Post> pages = page.getContent();
    //     return pages.stream().map((e)->modelMapper.map(e, PostDto.class)).collect(Collectors.toList());
    // }

    //v-3


    @Override
    public PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy){
        Pageable p = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        Page <Post> page = postRepo.findAll(p);
        List<Post> pages = page.getContent();
      
        PostResponse postResponse = new PostResponse();
        List<PostDto> postDto = pages.stream().map((e)->modelMapper.map(e, PostDto.class)).collect(Collectors.toList());

        postResponse.setContent(postDto);
        postResponse.setPageNumber( page.getNumber());
        postResponse.setPageSize(page.getSize());
        postResponse.setTotalElements(page.getTotalElements());
        postResponse.setTotalPages(page.getTotalPages());
        postResponse.setLast(page.isLast());

        return postResponse;
    }
    

    @Override
    public PostDto getPostById(Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post",postId));
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> getPostByCategory(Integer category_id) {
        Categories categories = categoryRepo.findById(category_id).orElseThrow(()->new ResourceNotFoundException("Category",category_id));
        List<Post> posts = postRepo.findByCategories(categories);
        return posts.stream().map(e->modelMapper.map(e, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getPostByUser(Integer user_id) {
        User user = userRepo.findById(user_id).orElseThrow(()->new ResourceNotFoundException("User",user_id));
        List<Post> posts = postRepo.findByUser(user);
        return posts.stream().map(e->modelMapper.map(e, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getPost() {
        List<Post> list = postRepo.findAll();
        return list.stream().map(e->modelMapper.map(e,PostDto.class)).collect(Collectors.toList());    }


    // search
    @Override
    public List<PostDto> searchPost(String keyword) {
        List<Post> posts = postRepo.findByNameContaining(keyword);
        return posts.stream().map(e->modelMapper.map(e,PostDto.class)).collect(Collectors.toList());
    }


    //delete

    @Override
    public void deletePost(Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post",postId));
        postRepo.delete(post);
    }

    
    
}
