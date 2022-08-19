package com.example.springdatatwo.repositories;

import com.example.springdatatwo.entities.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findProductByName(String name, Sort s);
}
