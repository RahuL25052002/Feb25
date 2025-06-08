package com.project.BlogApp.service.implementation;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.BlogApp.entity.Categories;
import com.project.BlogApp.exception.ResourceNotFoundException;
import com.project.BlogApp.paylod.CategoryDto;
import com.project.BlogApp.repository.CategoryRepo;
import com.project.BlogApp.service.CategoryService;

@Service
public class CategoryImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;
    
    @Autowired
    ModelMapper modelMapper;
    //ModelMapper modelMapper = new ModelMapper();

   
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
    
        Categories category = modelMapper.map(categoryDto,Categories.class);

        // Category category2 = categoryRepo.save(category);
        // return modelMapper.map(categoryRepo.save(category),CategoryDto.class);
        
        return modelMapper.map(categoryRepo.save(category),CategoryDto.class);

    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
    
        Categories category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category",categoryId));
        
        category.setCategory_id(categoryDto.getCategory_id());
        category.setTitle(categoryDto.getTitle());
        category.setDescription(categoryDto.getDescription());

        Categories categories = categoryRepo.save(category);

        return modelMapper.map(categories, CategoryDto.class);
        
    }

    @Override
    public CategoryDto getCategoryById(Integer categoryId) {
        Categories category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category",categoryId));
        return modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategories() {

        List<Categories> categories = categoryRepo.findAll();
        return categories.stream().map((var)->modelMapper.map(var, CategoryDto.class)).collect(Collectors.toList());
        
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category",categoryId));
        categoryRepo.deleteById(categoryId);
    }
    
}
