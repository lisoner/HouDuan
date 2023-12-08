package com.example.houduan.dao;

import com.example.houduan.entity.ShopItem;
import com.example.houduan.service.ShopItemService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IShopItemDao extends JpaRepository<ShopItem, Integer> {
    ShopItem save(ShopItem shopItem);
    @Transactional
    Integer deleteByShop_ShopIdAndItem_ItemId(Integer shop_id, Integer item_id);
    List<ShopItem> findByShopShopId(Integer shop_id);
}
