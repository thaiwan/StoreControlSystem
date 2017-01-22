package entity;

import javax.persistence.*;

@Entity(name = "product")
@NamedQuery(name = "Product.getAll", query = "SELECT p from product p")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "name")
    private String name;

    public Product() {

    }

    public Product(String name) {
        this.name = name;
    }

    public int getProductId() {

        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
