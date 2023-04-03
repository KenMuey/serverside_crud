package sit.int204.classicmodelsservice.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Column(name = "productCode", nullable = false)
    private String productCode;

    @Column(name = "productName", nullable = false, length = 70)
    private String productName;
    @Column(name = "productLine", nullable = false, length = 50)
    private String productLine;
    @Column(name = "productScale", nullable = false, length = 10)
    private String productScale;
    @Column(name = "productVendor", nullable = false, length = 50)
    private String productVendor;
    @Column(name = "productDescription", nullable = false, length = 1000)
    private String productDescription;
    @Column(name = "quantityInStock", nullable = false, length = 50)
    private Integer quantityInStock;
    @Column(name = "buyPrice", nullable = false, length = 50)
    private Double buyPrice;
    @Column(name = "MSRP", nullable = false, length = 50)
    private Double price;
}
