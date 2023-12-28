package com.example.houduan.Controller;

import com.example.houduan.dao.IOrderTableDao;
import com.example.houduan.entity.Item;
import com.example.houduan.entity.OrderTable;
import com.example.houduan.service.OrderTableService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping
@Tag(name = "OrderTable", description = "OrderTableController")
public class OrderTableController {
    @Resource
    IOrderTableDao iOrderTableDao;
    @Resource
    OrderTableService orderTableService;
    @Autowired
    public OrderTableController(IOrderTableDao iOrderTableDao) {
        this.iOrderTableDao = iOrderTableDao;
    }

    @Operation(summary = "根据顾客id、门店id、订单状态找到订单" ,description = "")
    @PostMapping("/FindOrderTableByCustomerIdShopIdOrderState")
    public OrderTable findOrderTable(@RequestParam Integer customer_id, @RequestParam Integer shop_id, @RequestParam Integer order_state){
        return iOrderTableDao.findByCustomer_CustomerIdAndShopShopIdAndOrderState(customer_id, shop_id, order_state);
    }

    @Operation(summary = "根据顾客id查顾客的订单" ,description = "")
    @PostMapping("/ListOrderTableByCustomerId")
    public List<OrderTable> listOrderTableByCustomerId(@RequestParam Integer customer_id){
        return orderTableService.findByCustomer_CustomerId(customer_id);
    }

    @Operation(summary = "保存/更新 订单信息" ,description = "")
    @PostMapping("/AddOrderTable")
    public OrderTable addOrderTable(@RequestParam Integer order_id, @RequestParam Integer customer_id, @RequestParam Integer shop_id, @RequestParam Integer order_state, @RequestParam Double order_cost){
        return orderTableService.addOrderTable(order_id,customer_id, shop_id, order_state, order_cost);
    }

    @Operation(summary = "根据门店id查订单列表" ,description = "")
    @PostMapping("/FindListOrderTableByShopId")
    public List<OrderTable> findListOrderTableByShopId(@RequestParam Integer shop_id) {
        return orderTableService.findByShopShopId(shop_id);
    }
}
