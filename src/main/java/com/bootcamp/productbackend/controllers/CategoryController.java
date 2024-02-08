package com.bootcamp.productbackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.productbackend.models.Category;
import com.bootcamp.productbackend.repositories.CategoryRepository;

@RestController
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;
    
    // @GetMapping("categories/{id}")
    // public ResponseEntity<Category> getCategory(@PathVariable int id) {

    //     Category category = categories.stream()
    //                               .filter(c -> c.getId() == id)
    //                               .findFirst()
    //                               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
                                  
    //     return ResponseEntity.ok(category);
    // }
    
    @GetMapping("categories")
    public List<Category> getCategories() {

        return categoryRepository.findAll();
    }
}
