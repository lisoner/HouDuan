package org.example.dao;

import org.example.entity.ShopItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopItemDao extends JpaRepository<ShopItem, Long> {
    List<ShopItem> findByShopId(Long shopId);
    // Other shop item-related queries
}
