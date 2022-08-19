package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepositories;

@Service
public class ProductService {

    /*
    * TRANSACTIONAL PROPAGATIONS
    * REQUIRED (default)
    * REQUIRES_NEW
    * MANDATORY 
    * NEVER
    * SUPPORTS
    * NOT_SUPPOSED
    * NESTED // RARELY USED
    *
    * a() ----> b()
     */

    @Autowired
    private ProductRepositories productRepositories;

    @Transactional
    public void addTenProduct() { // created
        for (int i = 1; i <= 10; i++) {
            productRepositories.addProduct("Product" + i);
            if (i == 5) throw new RuntimeException(":(");
        }
    } // commits
}
