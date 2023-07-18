package com.sportyshoes.dto;

import com.sportyshoes.entity.Order;
import com.sportyshoes.utils.BaseResponse;

import java.util.List;

public class CreateOrderResponseDTO extends BaseResponse {
    private Order order;
    private List<Order> orders;

    public CreateOrderResponseDTO() {}

    public CreateOrderResponseDTO(Order order, List<Order> orders) {
        this.order = order;
        this.orders = orders;
    }

    public CreateOrderResponseDTO(String message, boolean isSuccess, Order order, List<Order> orders) {
        super(message, isSuccess);
        this.order = order;
        this.orders = orders;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
