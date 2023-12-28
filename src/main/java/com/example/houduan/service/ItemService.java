package com.example.houduan.service;

import com.example.houduan.dto.ItemDTO;
import com.example.houduan.entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    List<ItemDTO> getBusinessItemList(Integer business_id);
    ItemDTO addItem(Integer business_id, String item_name, Double item_price);
    Item findByItemId(Integer item_id);
}
