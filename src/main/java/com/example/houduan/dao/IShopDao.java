package com.example.houduan.dao;

import com.example.houduan.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IShopDao extends JpaRepository<Shop, Integer> {
    Shop findByShopName(String shop_name);
    Shop findByShopId(Integer shop_id);
    List<Shop> findShopsByBusiness_BusinessIdAndIsDeletedIsNull(Integer business_id);
    boolean existsByShopName(String shop_name);
    Shop save(Shop shop);
}
