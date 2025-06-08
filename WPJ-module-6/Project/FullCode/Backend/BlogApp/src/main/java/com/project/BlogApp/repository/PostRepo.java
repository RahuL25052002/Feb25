package com.project.BlogApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.BlogApp.entity.Categories;
import com.project.BlogApp.entity.Post;
import com.project.BlogApp.entity.User;

public interface PostRepo extends JpaRepository<Post,Integer>{
    List<Post> findByUser(User user);
    List<Post> findByCategories(Categories categories);
    List<Post> findByNameContaining(String kayword);
}
