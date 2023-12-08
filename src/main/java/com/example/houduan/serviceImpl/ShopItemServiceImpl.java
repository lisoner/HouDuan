package com.example.houduan.serviceImpl;

import com.example.houduan.dao.IBusinessDao;
import com.example.houduan.dao.IItemDao;
import com.example.houduan.dao.IShopDao;
import com.example.houduan.dao.IShopItemDao;
import com.example.houduan.entity.Item;
import com.example.houduan.entity.Shop;
import com.example.houduan.entity.ShopItem;
import com.example.houduan.service.ShopItemService;
import com.example.houduan.service.ShopService;
import jakarta.annotation.Resource;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@CommonsLog
public class ShopItemServiceImpl implements ShopItemService {
    @Resource
    IShopDao iShopDao;
    @Resource
    IItemDao iItemDao;
    @Resource
    IShopItemDao iShopItemDao;
    @Override
    public ShopItem addShopItem(Integer shop_id, Integer item_id) {
        Shop shop = iShopDao.findByShopId(shop_id);
        Item item = iItemDao.findByItemId(item_id);
        ShopItem newShopItem = ShopItem.builder()
                .shop(shop)
                .item(item)
                .build();
        return iShopItemDao.save(newShopItem);
    }

    @Override
    public Integer deleteShopItem(Integer shop_id, Integer item_id) {
        /*ShopItem deleteByShop_ShopIdAndItem_ItemId(Integer shop_id, Integer item_id);*/
        return iShopItemDao.deleteByShop_ShopIdAndItem_ItemId(shop_id, item_id);
    }

    @Override
    public List<ShopItem> shopItemList(Integer shop_id) {
        return iShopItemDao.findByShopShopId(shop_id);
    }
}
