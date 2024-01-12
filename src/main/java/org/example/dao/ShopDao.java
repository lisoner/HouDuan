package org.example.dao;

import org.example.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopDao extends JpaRepository<Shop, Long> {
    Shop findByNameAndPassword(String name, String password);

}
