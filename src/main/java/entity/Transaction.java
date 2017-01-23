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

    @Column(name = "store")
    private int storeId;

    @Column(name = "transaction_date")
    private Date transactionDate;

    @Column(name = "count")
    private int count;

    @Column(name = "cost")
    private int cost;

    @Column(name = "product_id")
    private int productId;

    public Transaction() {

    }

    public Transaction(int storeId, Date transactionDate, int count, int cost, int productId) {
        this.storeId = storeId;
        this.transactionDate = transactionDate;
        this.count = count;
        this.cost = cost;
        this.productId = productId;
    }

    public int getStoreId() {

        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
}
