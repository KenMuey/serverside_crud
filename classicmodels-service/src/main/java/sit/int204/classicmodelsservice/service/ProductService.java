package sit.int204.classicmodelsservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import sit.int204.classicmodelsservice.entities.Office;
import sit.int204.classicmodelsservice.entities.Product;
import sit.int204.classicmodelsservice.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repoProduct;

    public Page<Product>  getAllProducts(Integer page,Integer size,String sortBy){
        Sort sort = Sort.by(sortBy);
        Pageable pageable = PageRequest.of(page,size,sort);
        return repoProduct.findAll(pageable);

    }
    public Product updateProduct(Product product,String productCode){
     Product existingProduct = repoProduct.findById(productCode).orElseThrow(() ->
             new HttpClientErrorException(HttpStatus.NOT_FOUND, "productCode " + productCode + " DOES NOT EXIST !!!"));
     existingProduct.setProductName(product.getProductName());
     existingProduct.setProductLine(product.getProductLine());
     existingProduct.setQuantityInStock(product.getQuantityInStock());
     existingProduct.setBuyPrice(product.getBuyPrice());
     return  repoProduct.saveAndFlush(existingProduct);
    }
    public Product addNewProduct(Product newProduct){
        return repoProduct.saveAndFlush(newProduct);
    }
    public List<Product> getProductMM(Double min,Double max) {
            return repoProduct.findProductByPriceBetweenOrderByPriceDesc(min, max);
    }
    public List<Product> getProductByProductLine(){
        Sort sortPdLine = Sort.by("productLine");
        return repoProduct.findAll(sortPdLine);
    }
    public Product getProductById(String productCode){
        int x = Integer.valueOf("a123");
        return repoProduct.findById(productCode).orElseThrow(
                ()-> new RuntimeException("Product id" +productCode+"does not exist"));
    }
}
