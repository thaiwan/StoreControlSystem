package entity;

import javax.persistence.*;

public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "store_id")
    private int storeId;

    @Column(name = "address")
    private String address;

    public Store(int storeId, String address) {
        this.storeId = storeId;
        this.address = address;
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
