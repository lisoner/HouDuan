package com.example.houduan.service;

import com.example.houduan.entity.Item;
import com.example.houduan.entity.Shop;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    List<Item> getBusinessItemList(Integer business_id);
}
