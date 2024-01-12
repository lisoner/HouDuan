package org.example.dto;

import org.example.entity.OrderStatus;

import java.util.List;

public class OrderDto {
    private Long id;
    private Long customerId;
    private List<LineItemDto> lineItems;
    private OrderStatus status;

    // Other order-related fields, getters, and setters
}
