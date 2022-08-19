package com.example.springdatatwo.controller;

import com.example.springdatatwo.entities.Product;
import com.example.springdatatwo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/sort")
    public Iterable<Product> getAllSortedDescendingById() {
        return productRepository.findAll(
                Sort.by("id")
                        .descending());
    }

    @GetMapping("/page/{page}")
    public List<Product> getProductsByPage(@PathVariable int page) {
//        Sort s = Sort.by("id").descending();
        return productRepository.findAll(PageRequest.of(page, 3)).getContent();
    }

    @GetMapping("/name/{name}/{page}")
    public List<Product> getProductsByName(@PathVariable String name,
                                           @PathVariable int page) {
        Pageable p = PageRequest.of(page, 2);
        return productRepository.findProductByName(name, Sort.by("id").descending());
    }
}
