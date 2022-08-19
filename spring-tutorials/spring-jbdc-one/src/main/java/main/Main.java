package main;

import config.ProjectConfig;
import model.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repo.ProductRepo;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (var c = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
            ProductRepo productRepo = c.getBean(ProductRepo.class);

//            Product p = new Product();
//            p.setName("Beer");
//            p.setPrice(10);
//
//            productRepo.addProduct(p);

            List<Product> products = productRepo.getProducts();
            products.forEach(System.out::println);

        }
    }
}
