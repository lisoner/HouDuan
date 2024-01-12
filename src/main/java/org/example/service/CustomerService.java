package org.example.service;

import org.example.dto.CustomerDto;
import org.example.dto.LineItemDto;
import org.example.dto.OrderDto;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);
    CustomerDto login(String name, String password);
    OrderDto createOrder(Long customerId, List<LineItemDto> lineItems);
    OrderDto payOrder(Long customerId, Long orderId);
    // Other customer-related methods
}