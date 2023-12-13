package com.example.houduan.dao;

import com.example.houduan.entity.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderListDao extends JpaRepository<OrderList, Integer> {
    List<OrderList> findByOrderTable_OrderId(Integer order_id);
    OrderList findByOrderTable_OrderIdAndItemItemId(Integer order_id, Integer item_id);
    OrderList save(OrderList orderList);
}
