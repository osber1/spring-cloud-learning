package com.osvaldas.learning.controller;

import com.osvaldas.learning.model.Product;
import com.osvaldas.learning.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/products")
public class ProductController {
    private final ProductRepository repository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<Product> findAll() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {
        return repository.save(product);
    }
}
