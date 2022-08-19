package com.example.springdatathree.controller;

import com.example.springdatathree.model.Product;
import com.example.springdatathree.respositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/all")
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @GetMapping("/name/{name}")
    public List<Product> findAll(@PathVariable String name) {
        return productRepository.findProductByName(name);
    }

}
