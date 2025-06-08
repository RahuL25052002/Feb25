package com.project.BlogApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.BlogApp.entity.Categories;


public interface CategoryRepo extends JpaRepository<Categories, Integer>{
    
}
