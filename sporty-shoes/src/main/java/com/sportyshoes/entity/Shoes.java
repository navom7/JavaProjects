package com.sportyshoes.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shoes")
public class Shoes {
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
    protected Set<Orders> orders = new HashSet<>();

    public Shoes() {
    }

    public Shoes(Long shoeid) {
        this.shoeid = shoeid;
    }

    public Shoes(Long shoeid, String name, String category, Long price) {
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
