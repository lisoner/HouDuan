package com.example.houduan.Controller;

import com.example.houduan.dto.OrderListDTO;
import com.example.houduan.entity.OrderList;
import com.example.houduan.entity.OrderTable;
import com.example.houduan.service.ItemService;
import com.example.houduan.service.OrderListService;
import com.example.houduan.service.OrderTableService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Order;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping
@Tag(name = "OrderList", description = "OrderListController")
public class OrderListController {
    @Resource
    OrderListService orderListService;
    @Resource
    ItemService itemService;
    @Resource
    OrderTableService orderTableService;

    @Autowired
    public OrderListController(OrderListService orderListService){
        this.orderListService = orderListService;
    }

    @Operation(summary = "根据订单id查订单购买的物品" ,description = "")
    @PostMapping("/ListOrderListByOrderId")
    public List<OrderListDTO> listOrderListByOrderId(@RequestParam Integer order_id){
        return orderListService.findByOrderTable_OrderId(order_id);
    }

    @Operation(summary = "保存此订单下的物品信息" ,description = "")
    @PostMapping("/SaveOrderList")
    public OrderListDTO saveOrderList(@RequestParam Integer id, Integer item_id, Integer order_id, Integer item_quantity){
        return orderListService.save(id, item_id, order_id, item_quantity);
    }

    @PostMapping("/ListOrderListByCustomerId")
    public List<OrderListDTO> listOrderListByCustomerId(@RequestParam Integer customer_id){
        return orderListService.findByOrderTable_Customer_CustomerId(customer_id);
    }
}
