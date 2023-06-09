package com.sportyshoes.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Long userid;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phonenumber")
    private String phonenumber;

    @Column(name = "role")
    private int role;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @MapKeyColumn(name = "orderid")
    protected Map<Long, Order> orders = new HashMap<>();

    public Map<Long, Order> getOrders() {
        return orders;
    }

    public Order getOrder(Long orderId){
        return this.orders.get(orderId);
    }

    public void addOrder(Order order) {
        order.setUser(this);
        this.orders.put(order.getOrderid(), order);
    }

    public User() {
    }

    public User(Long userid) {
        this.userid = userid;
    }

    public User(Long userid, String name, String email, String phonenumber, int role, String password) {
        this.userid = userid;
        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;
        this.role = role;
        this.password = password;
    }

    public User(String name, String email, String phonenumber, int role, String password) {
        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;
        this.role = role;
        this.orders = orders;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getRole() == user.getRole() && Objects.equals(getUserid(), user.getUserid()) && Objects.equals(getName(), user.getName()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getPhonenumber(), user.getPhonenumber()) && Objects.equals(orders, user.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserid(), getName(), getEmail(), getPhonenumber(), getRole(), orders);
    }
}
