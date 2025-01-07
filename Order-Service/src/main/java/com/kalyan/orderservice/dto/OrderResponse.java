package com.kalyan.orderservice.dto;

import java.math.BigDecimal;

public record OrderResponse(Long id, String orderNumber, String skuCode, Integer quantity, BigDecimal price) {


}
