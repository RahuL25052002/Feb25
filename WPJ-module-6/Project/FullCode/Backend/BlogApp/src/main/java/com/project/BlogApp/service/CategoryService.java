package com.project.BlogApp.service;

import java.util.List;
import com.project.BlogApp.paylod.CategoryDto;


public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto, Integer postId);

    CategoryDto getCategoryById(Integer CategoryId);

    List<CategoryDto> getAllCategories();

    void deleteCategory(Integer categoryId);
}
