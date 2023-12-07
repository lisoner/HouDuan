package com.example.houduan.dao;

import com.example.houduan.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IItemDao extends JpaRepository<Item, Integer> {
    List<Item> findByBusiness_BusinessId(Integer business_id);
}
