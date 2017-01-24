package entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;


@Entity(name = "store")
@NamedQuery(name = "Store.getAll", query = "SELECT s from store s")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "store_id")
    private int storeId;

    @Column(name = "address")
    private String address;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "store")
    @Cascade(org.hibernate.annotations.CascadeType.REMOVE)
    private Set<Transaction> transactions;

    public Store(int storeId, String address) {
        this.storeId = storeId;
        this.address = address;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Store(String address) {
        this.address = address;
    }

    public Store() {
    }

    public int getStoreId() {

        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
