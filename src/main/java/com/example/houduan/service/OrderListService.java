package com.example.houduan.service;

import com.example.houduan.entity.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderListService {
    List<OrderList> findByOrderTable_OrderId(Integer order_id);
    OrderList findByOrderTable_OrderIdAndItemItemId(Integer order_id, Integer item_id);
    OrderList save(OrderList orderList);
}
