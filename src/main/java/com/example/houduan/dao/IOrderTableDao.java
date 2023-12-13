package com.example.houduan.dao;

import com.example.houduan.entity.OrderTable;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderTableDao extends JpaRepository<OrderTable, Integer> {
    OrderTable save(OrderTable orderTable);
    OrderTable findByCustomer_CustomerId(Integer customer_id);
    List<OrderTable> findByShopShopId(Integer shop_id);
    List<OrderTable> findByOrderState(Integer order_state);
    OrderTable findByCustomer_CustomerIdAndShopShopIdAndOrderState(Integer customer_id, Integer shop_id, Integer order_state);


}
