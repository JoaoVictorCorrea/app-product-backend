package com.bootcamp.productbackend.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bootcamp.productbackend.dtos.CategoryRequestDTO;
import com.bootcamp.productbackend.dtos.CategoryResponseDTO;
import com.bootcamp.productbackend.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("{id}")
    public ResponseEntity<CategoryResponseDTO> getCategory(@PathVariable int id) {

        CategoryResponseDTO category = categoryService.getDTOById(id);

        return ResponseEntity.ok(category);
    }
    
    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getCategories() {

        return ResponseEntity.ok(categoryService.getAll()); 
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> save(@Validated @RequestBody CategoryRequestDTO categoryRequest) {

        CategoryResponseDTO category = categoryService.save(categoryRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(category.getId())
                .toUri();

        return ResponseEntity.created(location).body(category);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> removeCategory(@PathVariable int id) {

        categoryService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("{id}")
    public ResponseEntity<Void> updateCategory(@PathVariable int id, @Valid @RequestBody CategoryRequestDTO categoryUpdate) {

        categoryService.update(id, categoryUpdate);

        return ResponseEntity.ok().build();
    }
}
