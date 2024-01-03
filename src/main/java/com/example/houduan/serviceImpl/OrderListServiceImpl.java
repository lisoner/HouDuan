package com.example.houduan.serviceImpl;

import com.example.houduan.dao.IOrderListDao;
import com.example.houduan.dto.OrderListDTO;
import com.example.houduan.dto.OrderTableDTO;
import com.example.houduan.entity.Item;
import com.example.houduan.entity.OrderList;
import com.example.houduan.entity.OrderTable;
import com.example.houduan.service.ItemService;
import com.example.houduan.service.OrderListService;
import com.example.houduan.service.OrderTableService;
import jakarta.annotation.Resource;
import lombok.extern.apachecommons.CommonsLog;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.hibernate.Hibernate.map;

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
    public List<OrderListDTO> findByItem_ItemId(Integer item_id) {
        List<OrderList> orderListList = iOrderListDao.findByItem_ItemId(item_id);
        List<OrderListDTO> orderListDTOList = new ArrayList<>();
        for(OrderList orderList : orderListList){
            OrderListDTO orderListDTO = OrderListDTO.builder()
                    .orderId(orderList.getOrderTable().getOrderId())
                    .Id(orderList.getId())
                    .itemId(orderList.getItem().getItemId())
                    .itemName(orderList.getItem().getItemName())
                    .itemQuantity(orderList.getItemQuantity())
                    .itemPrice(orderList.getItem().getItemPrice())
                    .build();
            orderListDTOList.add(orderListDTO);
        }
        return orderListDTOList;
    }

    @Override
    public List<OrderListDTO> findByOrderTable_OrderId(Integer order_id) {
        List<OrderList> orderListList = iOrderListDao.findByOrderTable_OrderId(order_id);
        List<OrderListDTO> orderListDTOList = new ArrayList<>();
        for(OrderList orderList : orderListList){
            OrderListDTO orderListDTO = OrderListDTO.builder()
                    .orderId(orderList.getOrderTable().getOrderId())
                    .Id(orderList.getId())
                    .itemId(orderList.getItem().getItemId())
                    .itemName(orderList.getItem().getItemName())
                    .itemQuantity(orderList.getItemQuantity())
                    .itemPrice(orderList.getItem().getItemPrice())
                    .build();
            orderListDTOList.add(orderListDTO);
        }
        return orderListDTOList;
    }

    @Override
    public OrderListDTO findByOrderTable_OrderIdAndItemItemId(Integer order_id, Integer item_id) {
        OrderList orderList = iOrderListDao.findByOrderTable_OrderIdAndItemItemId(order_id, item_id);
        return OrderListDTO.builder()
                .orderId(orderList.getOrderTable().getOrderId())
                .Id(orderList.getId())
                .itemId(orderList.getItem().getItemId())
                .itemName(orderList.getItem().getItemName())
                .itemQuantity(orderList.getItemQuantity())
                .itemPrice(orderList.getItem().getItemPrice())
                .build();
    }

    @Override
    public OrderListDTO save(Integer id, Integer item_id, Integer order_id, Integer item_quantity) {
        ModelMapper modelMapper = new ModelMapper();
        // 修改匹配策略为严格
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Item item = itemService.findByItemId(item_id);
        OrderTable orderTable = orderTableService.findByOrderId(order_id);
        /*如果之前没有这个数据，则新增*/
        if (id == 0) {
            OrderList newOrderList = OrderList.builder()
                    .item(item)
                    .itemQuantity(item_quantity)
                    .orderTable(orderTable)
                    .build();
            OrderList orderList = iOrderListDao.save(newOrderList);
            return OrderListDTO.builder()
                    .orderId(orderList.getOrderTable().getOrderId())
                    .Id(orderList.getId())
                    .itemId(orderList.getItem().getItemId())
                    .itemName(orderList.getItem().getItemName())
                    .itemQuantity(orderList.getItemQuantity())
                    .itemPrice(orderList.getItem().getItemPrice())
                    .build();
        } else {/*如果之前有数据，即id!=0(在前端查找，因为前端要先展示出来)，则更改*/
            OrderList newOrderList = OrderList.builder()
                    .id(id)
                    .item(item)
                    .itemQuantity(item_quantity)
                    .orderTable(orderTable)
                    .build();
            OrderList orderList = iOrderListDao.save(newOrderList);
            return OrderListDTO.builder()
                    .orderId(orderList.getOrderTable().getOrderId())
                    .Id(orderList.getId())
                    .itemId(orderList.getItem().getItemId())
                    .itemName(orderList.getItem().getItemName())
                    .itemQuantity(orderList.getItemQuantity())
                    .itemPrice(orderList.getItem().getItemPrice())
                    .build();

        }
    }

    @Override
    public List<OrderListDTO> findByOrderTable_Customer_CustomerId(Integer customer_id) {
        List<OrderList> orderListList = iOrderListDao.findByOrderTable_Customer_CustomerId(customer_id);
        List<OrderListDTO> orderListDTOList = new ArrayList<>();
        for(OrderList orderList : orderListList){
            OrderListDTO orderListDTO = OrderListDTO.builder()
                    .orderId(orderList.getOrderTable().getOrderId())
                    .Id(orderList.getId())
                    .itemId(orderList.getItem().getItemId())
                    .itemQuantity(orderList.getItemQuantity())
                    .itemPrice(orderList.getItem().getItemPrice())
                    .build();
            orderListDTOList.add(orderListDTO);
        }
        return orderListDTOList;
    }
}
