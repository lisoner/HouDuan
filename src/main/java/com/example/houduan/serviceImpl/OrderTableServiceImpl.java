package com.example.houduan.serviceImpl;

import com.example.houduan.dao.*;
import com.example.houduan.dto.*;
import com.example.houduan.entity.Customer;
import com.example.houduan.entity.OrderList;
import com.example.houduan.entity.OrderTable;
import com.example.houduan.entity.Shop;
import com.example.houduan.service.CustomerService;
import com.example.houduan.service.OrderListService;
import com.example.houduan.service.OrderTableService;
import com.example.houduan.service.ShopService;
import jakarta.annotation.Resource;
import lombok.extern.apachecommons.CommonsLog;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Component
@CommonsLog
public class OrderTableServiceImpl implements OrderTableService {
    @Resource
    IOrderTableDao iOrderTableDao;
    @Resource
    CustomerService customerService;
    @Resource
    ShopService shopService;
    @Autowired
    protected ModelMapper modelMapper;

    public OrderTableServiceImpl(IOrderTableDao iOrderTableDao) {
        this.iOrderTableDao = iOrderTableDao;
    }

    @Override
    public OrderTable addOrderTable(Integer order_id, Integer customer_id, Integer shop_id, Integer order_state, Double order_cost) {
        if(order_id != 0){
            Customer customer = customerService.findByCustomerId(customer_id);
            Shop shop = shopService.findByShopId(shop_id);
            OrderTable newOrderTable = OrderTable.builder()
                    .orderId(order_id)
                    .orderState(order_state)
                    .orderCost(order_cost)
                    .customer(customer)
                    .shop(shop)
                    .build();
            return iOrderTableDao.save(newOrderTable);
        }else{
            Customer customer = customerService.findByCustomerId(customer_id);
            Shop shop = shopService.findByShopId(shop_id);
            OrderTable newOrderTable = OrderTable.builder()
                    .orderState(order_state)
                    .orderCost(order_cost)
                    .customer(customer)
                    .shop(shop)
                    .build();
            return iOrderTableDao.save(newOrderTable);
        }
    }

    @Override
    public List<OrderTable> findByCustomer_CustomerId(Integer customer_id) {
        return iOrderTableDao.findByCustomer_CustomerId(customer_id);
    }

    @Override
    public OrderTable findByOrderId(Integer order_id) {
        return iOrderTableDao.findByOrderId(order_id);
    }

    @Override
    public List<OrderTable> findByShopShopId(Integer shop_id) {
        return iOrderTableDao.findByShopShopId(shop_id);
    }

    @Override
    public List<OrderTable> findByOrderState(Integer order_state) {
        return iOrderTableDao.findByOrderState(order_state);
    }

    @Override
    public List<OrderTable> findByCustomer_CustomerIdAndShopShopIdAndOrderState(Integer customer_id, Integer shop_id, Integer order_state) {
        return iOrderTableDao.findByCustomer_CustomerIdAndShopShopIdAndOrderState(customer_id,shop_id,order_state);
    }
}
