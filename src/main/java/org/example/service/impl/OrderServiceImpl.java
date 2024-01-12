package org.example.service.impl;

import org.example.dao.OrderDao;
import org.example.dto.OrderDto;
import org.example.entity.Customer;
import org.example.entity.Order;
import org.example.entity.Shop;
import org.example.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao;

    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto, Long customerId, Long shopId) {
        Order order = new Order();
        BeanUtils.copyProperties(orderDto, order);

        // 设置顾客和商店
        Customer customer = new Customer();
        customer.setId(customerId);
        order.setCustomer(customer);

        Shop shop = new Shop();
        shop.setId(shopId);
        order.setShop(shop);

        order = orderDao.save(order);
        BeanUtils.copyProperties(order, orderDto);
        return orderDto;
    }

    @Override
    public OrderDto payOrder(Long orderId) {
        // 将订单标记为已支付的逻辑
        return null;
    }

    @Override
    public OrderDto cancelOrder(Long orderId) {
        // 取消订单的逻辑
        return null;
    }

    @Override
    public OrderDto confirmOrder(Long orderId) {
        // 确认订单的逻辑
        return null;
    }

    @Override
    public OrderDto refundOrder(Long orderId) {
        // 处理订单退款的逻辑
        return null;
    }

    @Override
    public List<OrderDto> getCustomerOrders(Long customerId) {
        List<Order> orders = orderDao.findByCustomerId(customerId);
        return orders.stream()
                .map(order -> {
                    OrderDto orderDto = new OrderDto();
                    BeanUtils.copyProperties(order, orderDto);
                    return orderDto;
                })
                .collect(Collectors.toList());
    }
}