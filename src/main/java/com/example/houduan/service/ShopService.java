package com.example.houduan.service;

import com.example.houduan.entity.Shop;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShopService {
    List<Shop> getAllShopList();
    List<Shop> getBusinessShopList(Integer business_id);
    Shop addShop(Integer business_id, String shop_name);
    Shop deleteShop(String shop_name);
}
