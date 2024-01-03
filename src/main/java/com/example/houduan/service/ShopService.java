package com.example.houduan.service;

import com.example.houduan.dto.ShopDTO;
import com.example.houduan.entity.Shop;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShopService {
    List<ShopDTO> getAllShopList();
    List<ShopDTO> findShopsByBusiness_BusinessIdAndIsDeletedIsNull(Integer business_id);
    ShopDTO addShop(Integer business_id, String shop_name);
    ShopDTO deleteShop(String shop_name);
    Shop findByShopId(Integer shop_id);
}
