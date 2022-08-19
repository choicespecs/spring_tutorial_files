package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Transactional ISOLATION
     *  DEFAULT ---> read committed
     *
     *  All isolations can affect performance.
     *  READ_UNCOMMITTED ---> dirty reads are possible
     *  READ_COMMITTED ---> dirty reads aren't possible but others are possible
     *  REAPEATABLE_READ --> repeatable reads aren't possible
     *  SERIALIZABLE --> avoid phantom reads
     *
     *  PROBLEMS:
     *  -dirty reads
     *  -repeatable reads
     *  -phantom reads
     *
     *  T1 -----100-----------110--------->
     *
     *
     *  T2 -----------10-C---------->
     *
     */
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void addTenProduct() {
        for (int i = 1; i <= 10; i++) {
            productRepository.addProduct("Product " + i);
        }
    }
}
