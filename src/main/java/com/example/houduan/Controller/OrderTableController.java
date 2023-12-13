package com.example.houduan.Controller;

import com.example.houduan.dao.IOrderTableDao;
import com.example.houduan.entity.Item;
import com.example.houduan.entity.OrderTable;
import com.example.houduan.service.OrderTableService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/FindOrderTable")
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

    @PostMapping("/AddOrderTable")
    public ResponseEntity<OrderTable> addOrderTable(@RequestParam Integer customer_id, @RequestParam Integer shop_id, @RequestParam Integer order_state){
        try{
            OrderTable newOrderTable = orderTableService.addOrderTable(customer_id, shop_id, order_state);
            if(newOrderTable != null){
                return new ResponseEntity<>(newOrderTable, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (NumberFormatException | NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}
