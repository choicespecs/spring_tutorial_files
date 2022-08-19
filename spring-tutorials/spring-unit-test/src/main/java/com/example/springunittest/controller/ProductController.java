package com.example.springunittest.controller;

import com.example.springunittest.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/product/{name}")
    public Product getProduct(@PathVariable String name) {
        Product p = new Product();
        p.setName(name);
        p.setPrice(10);
        return p;
    }

}
