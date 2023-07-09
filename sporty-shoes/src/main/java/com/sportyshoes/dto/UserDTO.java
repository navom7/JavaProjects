package com.sportyshoes.dto;

import jakarta.persistence.Column;

public class UserDTO {
    private Long userid;

    private String name;

    private String email;

    private String phonenumber;

    private int role;

    public UserDTO() {
    }

    public UserDTO(Long userid, String name, String email, String phonenumber, int role) {
        this.userid = userid;
        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;
        this.role = role;
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
}
