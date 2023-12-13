package com.example.houduan.serviceImpl;

import com.example.houduan.dao.IOrderListDao;
import com.example.houduan.entity.OrderList;
import com.example.houduan.service.OrderListService;
import jakarta.annotation.Resource;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@CommonsLog
public class OrderListServiceImpl implements OrderListService {
    @Resource
    IOrderListDao iOrderListDao;

    @Override
    public List<OrderList> findByOrderTable_OrderId(Integer order_id) {
        return iOrderListDao.findByOrderTable_OrderId(order_id);
    }

    @Override
    public OrderList findByOrderTable_OrderIdAndItemItemId(Integer order_id, Integer item_id) {
        return iOrderListDao.findByOrderTable_OrderIdAndItemItemId(order_id,item_id);
    }

    @Override
    public OrderList save(OrderList orderList) {
        return iOrderListDao.save(orderList);
    }
}
