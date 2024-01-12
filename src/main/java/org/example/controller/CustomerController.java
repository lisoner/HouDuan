package org.example.controller;

import org.example.service.CustomerService;
import org.example.dto.LineItemDto;
import org.example.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // 顾客创建订单
    @PostMapping("/{customerId}/orders")
    public OrderDto createOrder(@PathVariable Long customerId, @RequestBody List<LineItemDto> lineItems) {
        return customerService.createOrder(customerId, lineItems);
    }

    // 顾客支付订单
    @PostMapping("/{customerId}/orders/{orderId}/pay")
    public OrderDto payOrder(@PathVariable Long customerId, @PathVariable Long orderId) {
        return customerService.payOrder(customerId, orderId);
    }
}
