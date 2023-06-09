package com.sportyshoes.entity;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "shoes")
public class Shoe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shoeid")
    private Long shoeid;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private Long price;

    @OneToMany(mappedBy = "shoes", cascade = CascadeType.ALL, orphanRemoval = true)
    @MapKeyColumn(name = "orderid")
    protected Map<Long, Order> orders = new HashMap<>();

    public Map<Long, Order> getOrders() {
        return orders;
    }

    public Order getOrder(Long orderid) {
        return this.orders.get(orderid);
    }

    public void addOrder(Long orderid, Order order) {
        this.orders.put(orderid, order);
    }

    public Shoe() {
    }

    public Shoe(Long shoeid) {
        this.shoeid = shoeid;
    }

    public Shoe(String name, String category, Long price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Shoe(Long shoeid, String name, String category, Long price) {
        this.shoeid = shoeid;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Long getShoeid() {
        return shoeid;
    }

    public void setShoeid(Long shoeid) {
        this.shoeid = shoeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
