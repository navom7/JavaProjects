package com.sportyshoes.dto;

import jakarta.persistence.Column;

public class ShoeDTO {
    private Long shoeid;

    private String name;

    private String category;

    private Long price;

    public ShoeDTO() {
    }

    public ShoeDTO(Long shoeid, String name, String category, Long price) {
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
