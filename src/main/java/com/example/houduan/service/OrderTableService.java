package com.example.houduan.service;

import com.example.houduan.entity.OrderTable;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public interface OrderTableService {
    OrderTable addOrderTable(Integer customer_id, Integer shop_id, Integer order_state);
    OrderTable findByCustomer_CustomerId(Integer customer_id);
    OrderTable findByOrderId(Integer order_id);
    List<OrderTable> findByShopShopId(Integer shop_id);
    List<OrderTable> findByOrderState(Integer order_state);
    OrderTable findByCustomer_CustomerIdAndShopShopIdAndOrderState(Integer customer_id, Integer shop_id, Integer order_state);

}
