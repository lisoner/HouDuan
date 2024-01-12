package org.example.service.impl;

import org.example.dao.ShopItemDao;
import org.example.dto.ShopItemDto;
import org.example.entity.ShopItem;
import org.example.service.ShopItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ShopItemServiceImpl implements ShopItemService {
    private final ShopItemDao shopItemDao;

    public ShopItemServiceImpl(ShopItemDao shopItemDao) {
        this.shopItemDao = shopItemDao;
    }

    @Override
    public ShopItemDto createShopItem(Long shopId, ShopItemDto shopItemDto) {
        ShopItem shopItem = new ShopItem();
        BeanUtils.copyProperties(shopItemDto, shopItem);
        shopItem.setShopId(shopId);
        shopItem = shopItemDao.save(shopItem);
        BeanUtils.copyProperties(shopItem, shopItemDto);
        return shopItemDto;
    }

    @Override
    public ShopItemDto getShopItem(Long shopItemId) {
        return null;
    }

    // Other shop item-related methods
}
