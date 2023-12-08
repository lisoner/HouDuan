package com.example.houduan.service;

import com.example.houduan.entity.Item;
import com.example.houduan.entity.ShopItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShopItemService {
    ShopItem addShopItem(Integer shop_id, Integer item_id);
    Integer deleteShopItem(Integer shop_id, Integer item_id);
    List<ShopItem> shopItemList(Integer shop_id);
}
