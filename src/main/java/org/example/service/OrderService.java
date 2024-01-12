package org.example.service;

import org.example.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDto, Long customerId, Long shopId);
    OrderDto payOrder(Long orderId);
    OrderDto cancelOrder(Long orderId);
    OrderDto confirmOrder(Long orderId);
    OrderDto refundOrder(Long orderId);
    List<OrderDto> getCustomerOrders(Long customerId);
}