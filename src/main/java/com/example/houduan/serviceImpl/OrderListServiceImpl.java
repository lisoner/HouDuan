package com.example.houduan.serviceImpl;

import com.example.houduan.dao.IOrderListDao;
import com.example.houduan.dto.OrderListDTO;
import com.example.houduan.entity.Item;
import com.example.houduan.entity.OrderList;
import com.example.houduan.entity.OrderTable;
import com.example.houduan.service.ItemService;
import com.example.houduan.service.OrderListService;
import com.example.houduan.service.OrderTableService;
import jakarta.annotation.Resource;
import lombok.extern.apachecommons.CommonsLog;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
    @Autowired
    protected ModelMapper modelMapper;

    @Override
    public List<OrderList> findByItem_ItemId(Integer item_id) {
        return iOrderListDao.findByItem_ItemId(item_id);
    }

    @Override
    public List<OrderListDTO> findByOrderTable_OrderId(Integer order_id) {
        List<OrderList> orderLists = iOrderListDao.findByOrderTable_OrderId(order_id);
        List<OrderListDTO> orderListDTOs = new ArrayList<>();

        for (OrderList orderList : orderLists) {
            OrderListDTO orderListDTO = modelMapper.map(orderList, OrderListDTO.class);
            orderListDTOs.add(orderListDTO);
        }

        return orderListDTOs;
    }

    @Override
    public OrderListDTO findByOrderTable_OrderIdAndItemItemId(Integer order_id, Integer item_id) {
        return modelMapper.map(iOrderListDao.findByOrderTable_OrderIdAndItemItemId(order_id,item_id), OrderListDTO.class);
    }

    @Override
    public OrderListDTO save(Integer id, Integer item_id, Integer order_id, Integer item_quantity) {
        Item item = itemService.findByItemId(item_id);
        OrderTable orderTable = orderTableService.findByOrderId(order_id);
        /*如果之前没有这个数据，则新增*/
        if(id==0){
            OrderList newOrderList = OrderList.builder()
                    .item(item)
                    .orderTable(orderTable)
                    .build();
            iOrderListDao.save(newOrderList);
            return modelMapper.map(newOrderList, OrderListDTO.class);
        } else{/*如果之前有数据，即id!=0(在前端查找，因为前端要先展示出来)，则更改*/
            OrderList orderList = OrderList.builder()
                    .id(id)
                    .item(item)
                    .orderTable(orderTable)
                    .itemQuantity(item_quantity)
                    .build();
            iOrderListDao.save(orderList);
            return modelMapper.map(orderList, OrderListDTO.class);

        }
    }

    @Override
    public List<OrderListDTO> findByOrderTable_Customer_CustomerId(Integer customer_id) {
        List<OrderList> orderLists = iOrderListDao.findByOrderTable_Customer_CustomerId(customer_id);
        List<OrderListDTO> orderListDTOs = new ArrayList<>();

        for (OrderList orderList : orderLists) {
            OrderListDTO orderListDTO = modelMapper.map(orderList, OrderListDTO.class);
            orderListDTOs.add(orderListDTO);
        }

        return orderListDTOs;
    }
}
