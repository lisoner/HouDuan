package com.example.houduan.Controller;

import com.example.houduan.dto.OrderDetailDTO;
import com.example.houduan.service.OrderDetailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping
@Tag(name = "OrderDetail", description = "OrderDetailController")
public class OrderDetailController {
    @Resource
    OrderDetailService orderDetailService;
    @Autowired
    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @Operation(summary = "根据顾客id查找ListOrderList" ,description = "")
    @PostMapping("/ListOrderDetailByCustomerId")
    public List<OrderDetailDTO> findOrderDetailListByCustomerId(Integer customer_id) {
        return orderDetailService.findOrderDetailListByCustomerId(customer_id);
    }

    @Operation(summary = "根据门店id查找ListOrderList" ,description = "")
    @PostMapping("/ListOrderDetailByShopId")
    public List<OrderDetailDTO> findOrderDetailListByShopId(Integer shop_id) {
        return orderDetailService.findOrderDetailListByShopId(shop_id);
    }

    @Operation(summary = "根据顾客、门店id、订单状况查找ListOrderList" ,description = "")
    @PostMapping("/ListOrderDetailByCustomerIdAndShopIdAndOrderState")
    public List<OrderDetailDTO> findByCustomer_CustomerIdAndShopShopIdAndOrderState(Integer customer_id, Integer
            shop_id, Integer order_state) {
        return orderDetailService.findByCustomer_CustomerIdAndShopShopIdAndOrderState(customer_id, shop_id, order_state);
    }
}
