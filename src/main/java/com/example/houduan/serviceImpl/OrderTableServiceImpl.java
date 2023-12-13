package com.example.houduan.serviceImpl;

import com.example.houduan.dao.ICustomerDao;
import com.example.houduan.dao.IOrderTableDao;
import com.example.houduan.dao.IShopDao;
import com.example.houduan.dao.IShopItemDao;
import com.example.houduan.entity.Customer;
import com.example.houduan.entity.OrderTable;
import com.example.houduan.entity.Shop;
import com.example.houduan.service.OrderTableService;
import jakarta.annotation.Resource;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@CommonsLog
public class OrderTableServiceImpl implements OrderTableService {
    @Resource
    IOrderTableDao iOrderTableDao;
    @Resource
    ICustomerDao iCustomerDao;
    @Resource
    IShopDao iShopDao;

    public OrderTableServiceImpl(IOrderTableDao iOrderTableDao) {
        this.iOrderTableDao = iOrderTableDao;
    }

    @Override
    public OrderTable addOrderTable(Integer customer_id, Integer shop_id, Integer order_state) {
        Customer customer = iCustomerDao.findByCustomerId(customer_id);
        Shop shop = iShopDao.findByShopId(shop_id);
        OrderTable orderTable = OrderTable.builder()
                .customer(customer)
                .shop(shop)
                .orderState(order_state)
                .build();
        return iOrderTableDao.save(orderTable);
    }

    @Override
    public OrderTable findByCustomer_CustomerId(Integer customer_id) {
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
    public OrderTable findByCustomer_CustomerIdAndShopShopIdAndOrderState(Integer customer_id, Integer shop_id, Integer order_state) {
        return iOrderTableDao.findByCustomer_CustomerIdAndShopShopIdAndOrderState(customer_id,shop_id,order_state);
    }
}
