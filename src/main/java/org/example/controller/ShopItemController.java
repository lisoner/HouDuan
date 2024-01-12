package org.example.controller;

import org.example.service.ShopItemService;
import org.example.dto.ShopItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shopItems")
public class ShopItemController {

    private final ShopItemService shopItemService;

    @Autowired
    public ShopItemController(ShopItemService shopItemService) {
        this.shopItemService = shopItemService;
    }

    // 商家上架商品
    @PostMapping("/{shopId}")
    public ShopItemDto createShopItem(@PathVariable Long shopId, @RequestBody ShopItemDto shopItemDTO) {
        return shopItemService.createShopItem(shopId, shopItemDTO);
    }
}
