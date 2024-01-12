package org.example.service;

import org.example.dto.ShopItemDto;

public interface ShopItemService {
    ShopItemDto createShopItem(Long shopId, ShopItemDto shopItemDTO);
    ShopItemDto getShopItem(Long shopItemId);

}
