package com.sportyshoes.service;

import com.sportyshoes.dto.CreateOrderRequestDTO;
import com.sportyshoes.dto.CreateOrderResponseDTO;
import com.sportyshoes.entity.Order;
import com.sportyshoes.entity.Shoe;
import com.sportyshoes.entity.User;
import com.sportyshoes.repository.OrderRepository;
import com.sportyshoes.repository.ShoeRepository;
import com.sportyshoes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final ShoeRepository shoeRepository;

    private final UserRepository userRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, ShoeRepository shoeRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.shoeRepository = shoeRepository;
        this.userRepository = userRepository;
    }

    public CreateOrderResponseDTO createOrder(CreateOrderRequestDTO orders) {
        Order order = new Order(orders.getUsername(), orders.getShoename());
        Shoe shoe = new Shoe(orders.getShoeid());
        User user = new User(orders.getUserid());
        orderRepository.save(order);
        shoeRepository.save(shoe);
        userRepository.save(user);
        return new CreateOrderResponseDTO("Order Created", true, order, null);
    }

    public ResponseEntity<CreateOrderResponseDTO>  getOrders() {
        List<Order> orders = orderRepository.findAll();
        return ResponseEntity.ok(new CreateOrderResponseDTO("Orders", true, null, orders));
    }
}
