package com.sportyshoes.controller;

import com.sportyshoes.dto.CreateOrderRequestDTO;
import com.sportyshoes.dto.CreateOrderResponseDTO;
import com.sportyshoes.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping("/create")
    public ResponseEntity<CreateOrderResponseDTO> createOrder(@RequestBody CreateOrderRequestDTO order) {
        CreateOrderResponseDTO orderResponse = orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderResponse);
    }

    @GetMapping("/fetch")
    public ResponseEntity<CreateOrderResponseDTO> getOrder() {
        return orderService.getOrders();
    }

}
