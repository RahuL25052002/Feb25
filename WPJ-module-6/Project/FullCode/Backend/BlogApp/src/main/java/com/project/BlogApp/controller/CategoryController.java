package com.project.BlogApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.BlogApp.paylod.APIResponse;
import com.project.BlogApp.paylod.CategoryDto;
import com.project.BlogApp.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {
    
    @Autowired
    CategoryService categoryService;
    
    //create
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){

        CategoryDto category = categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(category,HttpStatus.CREATED);
    }

//    //update
//    @PutMapping("/{id}")
//    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer id){
//        CategoryDto category = categoryService.updateCategory(categoryDto, id);
//        return new ResponseEntity<CategoryDto>(category, HttpStatus.OK);
//    }
//
    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(new APIResponse("Category Deleted Successfully",true),HttpStatus.OK);
    }
    //get
//
//    @GetMapping("/{id}")
//    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer id){
//        CategoryDto category = categoryService.getCategoryById(id);
//        return new ResponseEntity<CategoryDto>(category, HttpStatus.FOUND);
//    }
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategories(){
        List<CategoryDto> categories = categoryService.getAllCategories();
        return new ResponseEntity<List<CategoryDto>>(categories, HttpStatus.OK);
    }
}
