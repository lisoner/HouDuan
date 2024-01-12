package org.example.service;

import org.example.dto.OrderDto;
import org.example.dto.ShopDto;
import org.example.dto.ShopItemDto;

import java.util.List;

public interface ShopService {
    ShopDto createShop(ShopDto shopDto, Long businessId);


    ShopItemDto createShopItem(Long shopId, ShopItemDto shopItemDTO);

    List<OrderDto> getShopOrders(Long shopId);

    OrderDto confirmOrder(Long shopId, Long orderId);

    OrderDto refundOrder(Long shopId, Long orderId);
}
