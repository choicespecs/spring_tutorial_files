package com.example.springdatathree.respositories;

import com.example.springdatathree.model.Product;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query("SELECT * FROM product WHERE name=:name")
    List<Product> findProductByName(String name);
}
