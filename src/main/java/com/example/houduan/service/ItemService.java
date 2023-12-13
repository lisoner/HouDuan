package com.example.houduan.service;

import com.example.houduan.entity.Item;
import com.example.houduan.entity.Shop;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    List<Item> getBusinessItemList(Integer business_id);
    Item addItem(Integer business_id, String item_name, Double item_price);
    Item findByItemId(Integer item_id);
}
