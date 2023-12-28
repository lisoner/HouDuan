package com.example.houduan.service;

import com.example.houduan.dto.OrderListDTO;
import com.example.houduan.entity.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderListService {
    List<OrderList> findByItem_ItemId(Integer item_id);
    List<OrderListDTO> findByOrderTable_OrderId(Integer order_id);
    OrderListDTO findByOrderTable_OrderIdAndItemItemId(Integer order_id, Integer item_id);
    OrderListDTO save(Integer id, Integer item_id, Integer order_id, Integer item_quantity);
    List<OrderListDTO> findByOrderTable_Customer_CustomerId(Integer customer_id);
}
