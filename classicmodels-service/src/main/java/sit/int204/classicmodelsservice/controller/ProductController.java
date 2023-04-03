package sit.int204.classicmodelsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sit.int204.classicmodelsservice.entities.Office;
import sit.int204.classicmodelsservice.entities.Product;
import sit.int204.classicmodelsservice.service.OfficeService;
import sit.int204.classicmodelsservice.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService serviceProduct;


    @GetMapping("")
    public Page<Product> getAllProduct(
                                       @RequestParam(defaultValue = "0") Integer page,
                                       @RequestParam(defaultValue = "10") Integer size,
                                       @RequestParam(defaultValue = "productCode") String sortBy) {
        return serviceProduct.getAllProducts( page, size,sortBy);
    }
    @PutMapping("/{productCode}")
    public Product updateProduct(@RequestBody Product product, @PathVariable String productCode) {
        return serviceProduct.updateProduct( product,productCode);
    }
    @PostMapping("")
    public Product create(@RequestBody Product newProduct){
        return  serviceProduct.addNewProduct(newProduct);
    }
    @GetMapping("/{min}/{max}")
    public List<Product> getProductMM(@PathVariable Double min,@PathVariable Double max){
        return serviceProduct.getProductMM(min,max);
    }
//    @GetMapping("/{productLine}")
//    public List<Product> getProductByProductLine(){
//      return serviceProduct.getProductByProductLine();
//    }



    @GetMapping("/{productCode}")
    public Product getProductsById(@PathVariable String productCode){
        return  serviceProduct.getProductById(productCode);
    }
}
