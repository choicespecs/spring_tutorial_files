package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepo;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Transactional
    // rollsback runtime exception, but not rollback the checked exception
    public void addOneProduct() {
        productRepo.addProduct("Beer");
        throw new RuntimeException(":(");
    }
}
