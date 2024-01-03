package com.example.houduan.service;

import com.example.houduan.dto.OrderDetailDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDetailService {
    List<OrderDetailDTO> findOrderDetailListByCustomerId(Integer customer_id);
    List<OrderDetailDTO> findOrderDetailListByShopId(Integer shop_id);
    List<OrderDetailDTO> findByCustomer_CustomerIdAndShopShopIdAndOrderState(Integer customer_id, Integer
            shop_id, Integer order_state);
}
