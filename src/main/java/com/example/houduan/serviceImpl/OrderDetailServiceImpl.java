package com.example.houduan.serviceImpl;

import com.example.houduan.dto.OrderDetailDTO;
import com.example.houduan.dto.OrderListDTO;
import com.example.houduan.dto.OrderTableDTO;
import com.example.houduan.entity.OrderList;
import com.example.houduan.entity.OrderTable;
import com.example.houduan.service.OrderDetailService;
import com.example.houduan.service.OrderListService;
import com.example.houduan.service.OrderTableService;
import jakarta.annotation.Resource;
import jakarta.persistence.criteria.Order;
import lombok.extern.apachecommons.CommonsLog;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@CommonsLog
public class OrderDetailServiceImpl implements OrderDetailService {
    @Resource
    OrderTableService orderTableService;
    @Resource
    OrderListService orderListService;
    @Autowired
    protected ModelMapper modelMapper;

    @Override
    public List<OrderDetailDTO> findOrderDetailListByCustomerId(Integer customer_id) {
        List<OrderTable> orderTableList = orderTableService.findByCustomer_CustomerId(customer_id);
        List<OrderDetailDTO> orderDetailDTOList = new ArrayList<>();
        for (OrderTable orderTable : orderTableList) {
            List<OrderListDTO> orderListDTOList = orderListService.findByOrderTable_OrderId(orderTable.getOrderId());
            OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
            modelMapper.map(orderTable, orderDetailDTO);
            orderDetailDTO.setOrderListDTOList(orderListDTOList);
            orderDetailDTOList.add(orderDetailDTO);
        }
        return orderDetailDTOList;
    }

    @Override
    public List<OrderDetailDTO> findOrderDetailListByShopId(Integer shop_id) {
        List<OrderTable> orderTableList = orderTableService.findByShopShopId(shop_id);
        List<OrderDetailDTO> orderDetailDTOList = new ArrayList<>();
        for (OrderTable orderTable : orderTableList) {
            List<OrderListDTO> orderListDTOList = orderListService.findByOrderTable_OrderId(orderTable.getOrderId());
            OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
            modelMapper.map(orderTable, orderDetailDTO);
            orderDetailDTO.setOrderListDTOList(orderListDTOList);
            orderDetailDTOList.add(orderDetailDTO);
        }
        return orderDetailDTOList;
    }

    @Override
    public List<OrderDetailDTO> findByCustomer_CustomerIdAndShopShopIdAndOrderState(Integer customer_id, Integer
            shop_id, Integer order_state) {
        List<OrderTable> orderTableList = orderTableService.findByCustomer_CustomerIdAndShopShopIdAndOrderState(customer_id, shop_id, order_state);
        List<OrderDetailDTO> orderDetailDTOList = new ArrayList<>();
        for (OrderTable orderTable : orderTableList) {
            List<OrderListDTO> orderListDTOList = orderListService.findByOrderTable_OrderId(orderTable.getOrderId());
            OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
            modelMapper.map(orderTable, orderDetailDTO);
            orderDetailDTO.setOrderListDTOList(orderListDTOList);
            orderDetailDTOList.add(orderDetailDTO);
        }
        return orderDetailDTOList;
    }
}
