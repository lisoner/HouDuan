package org.example.dao;
import org.example.entity.Order;
import org.example.entity.Customer;
import org.example.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Order, Long> {
    List<Order> findByCustomerId(Long customerId);

    List<Order> findByShop_IdAndCustomer_IdAndStatusNot(Long shopId, Long customerId, OrderStatus status);

    Order findByIdAndCustomer_Id(Long id, Long customerId);

    Order findByIdAndShopId(Long orderId, Long shopId);

}