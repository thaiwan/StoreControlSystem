package entity;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "transaction")
@NamedQuery(name = "Transaction.getAll", query = "SELECT t from transaction t")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_id")
    private int transactionId;

    @ManyToOne
    @JoinColumn (name = "store")
    private Store store;

    @Column(name = "transaction_date")
    private Date transactionDate;

    @Column(name = "count")
    private int count;

    @Column(name = "cost")
    private int cost;

    @ManyToOne
    @JoinColumn (name = "product_id")
    private Product product;

    public Transaction() {

    }

    public Transaction(Store store, Date transactionDate, int count, int cost, Product product) {
        this.store = store;
        this.transactionDate = transactionDate;
        this.count = count;
        this.cost = cost;
        this.product = product;
    }


    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
