package com.bootcamp.productbackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bootcamp.productbackend.dtos.CategoryRequestDTO;
import com.bootcamp.productbackend.dtos.CategoryResponseDTO;
import com.bootcamp.productbackend.models.Category;
import com.bootcamp.productbackend.repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    
    public Category getById(int id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));

        return category;
    }
    
    public List<Category> getAll() {

        return categoryRepository.findAll();
    }
    
    public CategoryResponseDTO save(CategoryRequestDTO categoryRequest) {

        Category category = categoryRepository.save(categoryRequest.toEntity());
        return category.toDTO();
    }
    
    public void deleteById(int id) {

        Category category = getById(id);

        categoryRepository.delete(category);
    }
    
    public void update(int id, Category categoryUpdate) {
        
        Category category = getById(id); 
        category.setName(categoryUpdate.getName());

        categoryRepository.save(category);
    }
}
