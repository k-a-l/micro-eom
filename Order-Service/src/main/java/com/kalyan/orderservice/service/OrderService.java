package com.kalyan.orderservice.service;

import com.kalyan.orderservice.dto.OrderRequest;
import com.kalyan.orderservice.dto.OrderResponse;
import com.kalyan.orderservice.entity.Order;
import com.kalyan.orderservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(order -> new OrderResponse
                        (order.getId(), order.getOrderNumber(), order.getSkuCode(), order.getQuantity(), order.getPrice())).toList();
    }
    public void addOrder(OrderRequest orderRequest) {
        Order order =new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setSkuCode(orderRequest.skuCode());
        order.setQuantity(orderRequest.quantity());
        order.setPrice(orderRequest.price());
        orderRepository.save(order);

    }


}
