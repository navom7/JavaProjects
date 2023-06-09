package com.sportyshoes.dto;

public class CreateOrderRequestDTO {

    private Long orderid;

    private Long userid;

    private Long shoeid;

    private String username;

    private String shoename;

    private String password;

    public CreateOrderRequestDTO() {
    }

    public CreateOrderRequestDTO(Long orderid, Long userid, Long shoeid, String username, String shoename, String password) {
        this.orderid = orderid;
        this.userid = userid;
        this.shoeid = shoeid;
        this.username = username;
        this.shoename = shoename;
        this.password = password;
    }

    public Long getOrderid() {
        return orderid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getShoeid() {
        return shoeid;
    }

    public void setShoeid(Long shoeid) {
        this.shoeid = shoeid;
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
