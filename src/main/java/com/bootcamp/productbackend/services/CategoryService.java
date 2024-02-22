package com.bootcamp.productbackend.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.bootcamp.productbackend.dtos.CategoryRequestDTO;
import com.bootcamp.productbackend.dtos.CategoryResponseDTO;
import com.bootcamp.productbackend.models.Category;
import com.bootcamp.productbackend.repositories.CategoryRepository;
import com.bootcamp.productbackend.services.exceptions.DatabaseException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    
    public CategoryResponseDTO getById(int id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        return category.toDTO();
    }
    
    public List<CategoryResponseDTO> getAll() {

        return categoryRepository.findAll()
                                 .stream()
                                 .map(c -> c.toDTO())
                                 .collect(Collectors.toList());
    }
    
    public CategoryResponseDTO save(CategoryRequestDTO categoryRequest) {

        Category category = categoryRepository.save(categoryRequest.toEntity());
        return category.toDTO();
    }
    
    public void deleteById(int id) {

        try {
            getById(id);
            categoryRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Constrain violation, category can't delete");
        }
    }
    
    public void update(int id, CategoryRequestDTO categoryUpdate) {
        
        try{
            Category category = categoryRepository.getReferenceById(id);
            category.setName(categoryUpdate.getName());
    
            categoryRepository.save(category);
        }
        catch(EntityNotFoundException e){
            throw new EntityNotFoundException("Category not found");
        }
    }
}
