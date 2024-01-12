package org.example.controller;

import org.example.service.ShopService;
import org.example.dto.OrderDto;
import org.example.dto.ShopItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shops")
public class ShopController {

    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    // 商家上架商品
    @PostMapping("/{shopId}/items")
    public ShopItemDto createShopItem(@PathVariable Long shopId, @RequestBody ShopItemDto shopItemDTO) {
        return shopService.createShopItem(shopId, shopItemDTO);
    }

    // 商家查看订单
    @GetMapping("/{shopId}/orders")
    public List<OrderDto> getShopOrders(@PathVariable Long shopId) {
        return shopService.getShopOrders(shopId);
    }

    // 商家确认订单
    @PostMapping("/{shopId}/orders/{orderId}/confirm")
    public OrderDto confirmOrder(@PathVariable Long shopId, @PathVariable Long orderId) {
        return shopService.confirmOrder(shopId, orderId);
    }

    // 商家取消已支付订单
    @PostMapping("/{shopId}/orders/{orderId}/refund")
    public OrderDto refundOrder(@PathVariable Long shopId, @PathVariable Long orderId) {
        return shopService.refundOrder(shopId, orderId);
    }
}
