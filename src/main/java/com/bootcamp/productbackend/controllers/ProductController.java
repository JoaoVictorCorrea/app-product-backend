package com.bootcamp.productbackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.productbackend.models.Product;
import com.bootcamp.productbackend.repositories.ProductRepository;

@RestController
@CrossOrigin
public class ProductController {

    //private List<Product> products = new ArrayList<>();

    @Autowired
    private ProductRepository productRepository;
    
    // @GetMapping("products/{id}")
    // public ResponseEntity<Product> getProduct(@PathVariable int id) {

    //     Product product = products.stream()
    //                               .filter(p -> p.getId() == id)
    //                               .findFirst()
    //                               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
                                  
    //     return ResponseEntity.ok(product);
    // }
    
    @GetMapping("products")
    public List<Product> getProducts() {

        return productRepository.findAll();
    }

    // @PostMapping("products")
    // public ResponseEntity<Product> save(@RequestBody Product product) {
        
    //     product.setId(products.size() + 1);
    //     products.add(product);

    //     URI location = ServletUriComponentsBuilder
    //             .fromCurrentRequest()
    //             .path("/{id}")
    //             .buildAndExpand(product.getId())
    //             .toUri();

    //     return ResponseEntity.created(location).body(product);
    // }
}
