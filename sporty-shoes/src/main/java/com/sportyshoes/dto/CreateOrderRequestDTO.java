package com.sportyshoes.dto;

public class CreateOrderRequestDTO {

    private Long orderid;

    private Long userid;

    private Long shoeid;

    private String username;

    private String shoename;

    public CreateOrderRequestDTO() {
    }

    public CreateOrderRequestDTO(Long orderid, Long userid, Long shoeid, String username, String shoename) {
        this.orderid = orderid;
        this.userid = userid;
        this.shoeid = shoeid;
        this.username = username;
        this.shoename = shoename;
    }

    public Long getOrderid() {
        return orderid;
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
