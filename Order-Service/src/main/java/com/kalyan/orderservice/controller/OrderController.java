package com.kalyan.orderservice.controller;

import com.kalyan.orderservice.dto.OrderRequest;
import com.kalyan.orderservice.dto.OrderResponse;
import com.kalyan.orderservice.entity.Order;
import com.kalyan.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    private final OrderService orderService;

    @GetMapping(path = "/")
    public List<OrderResponse> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping(path = "/addOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public String addOrder(@RequestBody OrderRequest orderRequest) {
        orderService.addOrder(orderRequest);
        return "Order added successfully";
    }

}
