package com.example.houduan.Controller;

import com.example.houduan.entity.OrderList;
import com.example.houduan.service.ItemService;
import com.example.houduan.service.OrderListService;
import com.example.houduan.service.OrderTableService;
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

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping
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


    @PostMapping("/ListOrderListByOrderId")
    public ResponseEntity<List<OrderList>> listOrderListByOrderId(@RequestParam Integer order_id){
        try{
            List<OrderList> orderListList = orderListService.findByOrderTable_OrderId(order_id);

            if (orderListList != null){
                return new ResponseEntity<>(orderListList, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }catch (NumberFormatException | NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/SaveOrderList")
    public ResponseEntity<OrderList> saveOrderList(@RequestParam Integer id, Integer item_id, Integer order_id, Integer item_quantity){
        try{
            OrderList orderList = orderListService.save(id, item_id, order_id, item_quantity);
            if (orderList != null){
                return new ResponseEntity<>(orderList, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (NumberFormatException | NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/ListOrderListByCustomerId")
    public ResponseEntity<List<OrderList>> listOrderListByCustomerId(@RequestParam Integer customer_id){
        try{
            List<OrderList> orderListList = orderListService.findByOrderTable_Customer_CustomerId(customer_id);

            if (orderListList != null){
                return new ResponseEntity<>(orderListList, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }catch (NumberFormatException | NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
