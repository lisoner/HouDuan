package com.example.houduan.serviceImpl;

import com.example.houduan.dao.IOrderListDao;
import com.example.houduan.entity.Item;
import com.example.houduan.entity.OrderList;
import com.example.houduan.entity.OrderTable;
import com.example.houduan.service.ItemService;
import com.example.houduan.service.OrderListService;
import com.example.houduan.service.OrderTableService;
import jakarta.annotation.Resource;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@CommonsLog
public class OrderListServiceImpl implements OrderListService {
    @Resource
    IOrderListDao iOrderListDao;
    @Resource
    ItemService itemService;
    @Resource
    OrderTableService orderTableService;

    @Override
    public List<OrderList> findByItem_ItemId(Integer item_id) {
        return iOrderListDao.findByItem_ItemId(item_id);
    }

    @Override
    public List<OrderList> findByOrderTable_OrderId(Integer order_id) {
        return iOrderListDao.findByOrderTable_OrderId(order_id);
    }

    @Override
    public OrderList findByOrderTable_OrderIdAndItemItemId(Integer order_id, Integer item_id) {
        return iOrderListDao.findByOrderTable_OrderIdAndItemItemId(order_id,item_id);
    }

    @Override
    public OrderList save(Integer id, Integer item_id, Integer order_id, Integer item_quantity) {
        Item item = itemService.findByItemId(item_id);
        OrderTable orderTable = orderTableService.findByOrderId(order_id);
        /*如果之前没有这个数据，则新增*/
        if(id==0){
            OrderList newOrderList = OrderList.builder()
                    .item(item)
                    .orderTable(orderTable)
                    .build();
            return iOrderListDao.save(newOrderList);
        } else{/*如果之前有数据，即id!=0(在前端查找，因为前端要先展示出来)，则更改*/
            OrderList orderList = OrderList.builder()
                    .id(id)
                    .item(item)
                    .orderTable(orderTable)
                    .itemQuantity(item_quantity)
                    .build();
            return iOrderListDao.save(orderList);
        }
    }
}
