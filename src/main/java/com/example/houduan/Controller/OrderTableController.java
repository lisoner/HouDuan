package com.example.houduan.Controller;

import com.example.houduan.dao.IOrderTableDao;
import com.example.houduan.entity.Item;
import com.example.houduan.entity.OrderTable;
import com.example.houduan.service.OrderTableService;
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
public class OrderTableController {
    @Resource
    IOrderTableDao iOrderTableDao;
    @Resource
    OrderTableService orderTableService;
    @Autowired
    public OrderTableController(IOrderTableDao iOrderTableDao) {
        this.iOrderTableDao = iOrderTableDao;
    }

    @PostMapping("/FindOrderTableByCustomerIdShopIdOrderState")
    public ResponseEntity<OrderTable> findOrderTable(@RequestParam Integer customer_id, @RequestParam Integer shop_id, @RequestParam Integer order_state){
        try{
            OrderTable orderTable = iOrderTableDao.findByCustomer_CustomerIdAndShopShopIdAndOrderState(customer_id, shop_id, order_state);

            if(orderTable != null){
                return new ResponseEntity<>(orderTable,HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }catch (NumberFormatException | NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/ListOrderTableByCustomerId")
    public ResponseEntity<List<OrderTable>> listOrderTableByCustomerId(@RequestParam Integer customer_id){
        try{
            List<OrderTable> orderTableList = orderTableService.findByCustomer_CustomerId(customer_id);
            if (orderTableList != null){
                return new ResponseEntity<>(orderTableList, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }catch (NumberFormatException | NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/AddOrderTable")
    public ResponseEntity<OrderTable> addOrderTable(@RequestParam Integer order_id, @RequestParam Integer customer_id, @RequestParam Integer shop_id, @RequestParam Integer order_state, @RequestParam Double order_cost){
        try{
            OrderTable newOrderTable = orderTableService.addOrderTable(order_id,customer_id, shop_id, order_state, order_cost);
            if(newOrderTable != null){
                return new ResponseEntity<>(newOrderTable, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (NumberFormatException | NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/FindListOrderTableByShopId")
    public ResponseEntity<List<OrderTable>> findListOrderTableByShopId(@RequestParam Integer shop_id){
        try{
            List<OrderTable> orderTableList = orderTableService.findByShopShopId(shop_id);
            return new ResponseEntity<>(orderTableList, HttpStatus.OK);
        }catch (NumberFormatException | NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
