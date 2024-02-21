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

import com.bootcamp.productbackend.dtos.ProductRequestDTO;
import com.bootcamp.productbackend.dtos.ProductResponseDTO;
import com.bootcamp.productbackend.services.ProductService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @GetMapping("{id}")
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable long id) {

        ProductResponseDTO product = productService.getDTOById(id);
                                  
        return ResponseEntity.ok(product);
    }
    
    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getProducts() {

        return ResponseEntity.ok(productService.getAll()); 
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> save(@Validated @RequestBody ProductRequestDTO productRequest) {

        ProductResponseDTO product = productService.save(productRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product.getId())
                .toUri();

        return ResponseEntity.created(location).body(product);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> removeProduct(@PathVariable long id) {

        productService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable long id, @Valid @RequestBody ProductRequestDTO productUpdate) {

        productService.update(id, productUpdate);

        return ResponseEntity.ok().build();
    }
}
