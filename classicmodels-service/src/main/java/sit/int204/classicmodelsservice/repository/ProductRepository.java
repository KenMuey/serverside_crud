package sit.int204.classicmodelsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelsservice.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,String> {
    List<Product> findProductByPriceBetweenOrderByPriceDesc(Double min,Double max);

}

