package com.example.houduan.dao;

import com.example.houduan.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IShopDao extends JpaRepository<Shop, Integer> {
    List<Shop> findShopsByBusiness_BusinessId(Integer business_id);
    boolean existsByShopName(String shop_name);
    Shop save(Shop shop);
}
