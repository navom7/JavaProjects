package com.sportyshoes.service;

import com.sportyshoes.dto.CreateOrderRequestDTO;
import com.sportyshoes.dto.CreateOrderResponseDTO;
import com.sportyshoes.entity.Orders;
import com.sportyshoes.entity.Shoes;
import com.sportyshoes.entity.User;
import com.sportyshoes.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public CreateOrderResponseDTO createOrder(CreateOrderRequestDTO orders) {
        Orders order = new Orders();
//        order.setOrderid(orders.getOrderid());
        order.setUser(new User("shakya", "shakya@gmail.com", "88888888", 1, new HashSet<>()));
        order.setShoes(new Shoes(orders.getShoeid()));
        order.setUsername(orders.getUsername());
        order.setShoename(orders.getShoename());

        Orders createdOrderResponse = orderRepository.save(order);

        return new CreateOrderResponseDTO();
    }
}
