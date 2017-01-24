package entity;


import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import java.util.Set;


@Entity(name = "product")
@NamedQuery(name = "Product.getAll", query = "SELECT p from product p")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "name")
    private String name;

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    @Cascade(org.hibernate.annotations.CascadeType.REMOVE)
    private Set<Transaction> transactions;

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
