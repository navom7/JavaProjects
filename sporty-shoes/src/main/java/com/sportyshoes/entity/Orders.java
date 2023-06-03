package com.sportyshoes.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Table(name = "orders")
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    private Long orderid;

    @ManyToOne
    @JoinColumn(name = "userid", updatable = false, nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "shoeid", updatable = false, nullable = false)
    private Shoes shoes;

    @Column(name = "username")
    private String username;

    @Column(name = "shoename")
    private String shoename;


    public Orders(Long orderid, User user, Shoes shoes, String username, String shoename) {
        this.orderid = orderid;
        this.user = user;
        this.shoes = shoes;
        this.username = username;
        this.shoename = shoename;
    }

    public Orders() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orders orders)) return false;
        return Objects.equals(getOrderid(), orders.getOrderid()) && Objects.equals(getUser(), orders.getUser()) && Objects.equals(getShoes(), orders.getShoes()) && Objects.equals(getUsername(), orders.getUsername()) && Objects.equals(getShoename(), orders.getShoename());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderid(), getUser(), getShoes(), getUsername(), getShoename());
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Shoes getShoes() {
        return shoes;
    }

    public void setShoes(Shoes shoes) {
        this.shoes = shoes;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getShoename() {
        return shoename;
    }

    public void setShoename(String shoename) {
        this.shoename = shoename;
    }
}
