package com.sportyshoes.dto;

public class ShoeRequestDTO {
    private Long ShoeId;
    private String Shoename;
    private String email;
    private String password;

    public ShoeRequestDTO() {
    }

    public ShoeRequestDTO(Long ShoeId, String Shoename, String email) {
        this.ShoeId = ShoeId;
        this.Shoename = Shoename;
        this.email = email;
    }

    public Long getShoeId() {
        return ShoeId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setShoeId(Long ShoeId) {
        this.ShoeId = ShoeId;
    }

    public String getShoename() {
        return Shoename;
    }

    public void setShoename(String Shoename) {
        this.Shoename = Shoename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
